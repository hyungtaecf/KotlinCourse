import java.util.*

//enum class is similar to enum in Java
enum class EntityType{
    EASY, MEDIUM, HARD;

    //You can add methods too
        //Formatting the name
    fun getFormattedName() = name.toLowerCase().capitalize()
}

/*interface IdProvider{
    fun getId(): String
}*/

object EntityFactory{
    //fun create() = Entity("id", "name")
    fun create(type: EntityType): Entity{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> "Easy"
                //EntityType.EASY -> type.name It references the name with no formatting (EASY)
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> "Hard"
        }
        return Entity(id, name)
    }
}

//class Entity private constructor(val id: String){
class Entity(val id: String, val name: String){
    //Companion Object: It is an object scoped to an instance of another class
    /*companion object Factory: IdProvider{ //You can rename your companion object (in this case Factory)
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


fun main(){
    //val entity = Entity.Companion.create() //In Kotlin Companion can be omitted, since it is implicit
    //val entity = Entity.create()
        //companion objects have access to private properties and methods of that enclosing class

    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val mediumEntity = EntityFactory.create(EntityType.MEDIUM)
    println(mediumEntity)
}