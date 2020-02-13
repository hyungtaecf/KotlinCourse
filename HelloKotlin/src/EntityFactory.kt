import java.util.*

//enum class is similar to enum in Java
enum class EntityType {
    //EASY, MEDIUM, HARD;
    HELP,
    EASY, MEDIUM, HARD;

    //You can add methods too
    //Formatting the name
    fun getFormattedName() = name.toLowerCase().capitalize()
}

/*interface IdProvider{
    fun getId(): String
}*/

object EntityFactory {
    //fun create() = Entity("id", "name")
    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> "Easy"
            //EntityType.EASY -> type.name It references the name with no formatting (EASY)
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.getFormattedName()
        }
        //return Entity(id, name)
        return when (type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}
/*
//class Entity private constructor(val id: String){
class Entity(val id: String, val name: String){
    //Companion Object: It is an object scoped to an instance of another class
    /*
    companion object Factory: IdProvider{ //You can rename your companion object (in this case Factory)
        override fun getId(): String {
            return "123"
        }
    companion object Factory{
        //const val id = "id" //You can make properties for the companion object
        //fun create() = Entity(id)
        fun create() = Entity("id")
    }
    */

    override fun toString(): String {
        return "id: $id name: $name"
    }
}
*/

//Sealed class: A sealed class allows you to represent constrained hierarchies
// in which an object can only be of one of the given types.
// That is, we have a class with a specific number of subclasses.
// A sealed class is abstract by itself,
// it cannot be instantiated directly and can have abstract members.
sealed class Entity() {
    object Help : Entity() {
        val name = "Help"
    }

    //Data class: We frequently create classes whose main purpose is to hold data.
    // In such a class some standard functionality and utility functions
    // are often mechanically derivable from the data.
    data class Easy(val id: String, val name: String) : Entity(){
        //You can change the equals and hashcode
        /*override fun equals(other: Any?): Boolean {
            return super.equals(other)
        }

        override fun hashCode(): Int {
            return super.hashCode()
        }*/
    }

    data class Medium(val id: String, val name: String) : Entity()
    //You can also use different types of class itself in a sealed class
    class Hard(val id: String, val name: String, val multiplier: Float) : Entity()

}



fun Entity.Medium.printInfo(){
    println("Medium class: $id")
}

val Entity.Medium.info: String
    get() = "some info"


fun main() {
    //val entity = Entity.Companion.create() //In Kotlin Companion can be omitted, since it is implicit
    //val entity = Entity.create()
    //companion objects have access to private properties and methods of that enclosing class

//    val entity = EntityFactory.create(EntityType.EASY)
//    println(entity)
//
//    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
//    println(mediumEntity)

//    val entity : Entity = EntityFactory.create(EntityType.HELP)
//    val msg = when(entity){
//        Entity.Help -> "help class"
//        is Entity.Easy -> "easy class"
//        is Entity.Medium -> "medium class"
//        is Entity.Hard -> "hard class"
//    }
//
//    println(msg)


    val entity1 = Entity.Easy("id", "name")
//    val entity2 = Entity.Easy("id", "name")
//    val entity3 = entity1.copy(name = "new name") //With data classes, You can copy them entirely or partially, changing some elements
//
//    if (entity1 == entity2) {
//        println("they are equal")
//    } else {
//        println("they are not equal")
//    }
//
//    if (entity1 == entity3) {
//        println("they are equal")
//    } else {
//        println("they are not equal")
//    }
//
//    if (entity1 === entity2) { //Use === to know if it is exactly the same reference
//        println("they are equal")
//    } else {
//        println("they are not equal")
//    }

    //Entity.Medium("id", "name").printInfo()

    val entity2 = EntityFactory.create(EntityType.MEDIUM)
    if(entity2 is Entity.Medium){
        entity2.printInfo()
    }
}