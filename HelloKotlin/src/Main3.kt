fun sayHello(greeting:String, vararg itemsToGreet:String){
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

//default values
fun greetPerson(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")


fun main(){
    val interestingThings = listOf("Kotlin", "Programming", "Comic Books")
    sayHello("Hi") //because of the vararg it understands that it has the parameter itemsToGreet as a empty list
    sayHello("Hi", "Kotlin", "Programming", "Comic Books")
    //sayHello("Hi", *interestingThings) //spread operator (*): in order to use arrays with vararg; but for some reason it is not working

    greetPerson(name="Ted",greeting="Hey")
    greetPerson(name="Ted")

    //Classes
    val person = Person()
    person.nickname = "New Nickname"
    println(person.nickname)

    val person2 = Person("Theo", "Figur")
    println(person2.printInfo())


}