var myGreeting: String? = "hello"

fun getGreeting() : String = "Hello Kotlin"
/* This is the same as following:
fun getGreeting() : String {
    return "Hello Kotlin"
}
*/

fun sayHello(){
    println(getGreeting())
}

fun main() {
    //Hello World
    println("Hello Kotlin")

        //val name: String = "Nate" --> val cannot change; var can change
    var name: String = "Nate"
    name = "John"

    //if else
    if(myGreeting!=null) {
        println(myGreeting + " " + name)
    } else{
        println("Hi")
    }
    println(if(myGreeting != null) myGreeting else "Hi")

    //when - similar to switch
    when(myGreeting){
        null -> println("Hi")
        else -> println(myGreeting)
    }
    val greetingToPrint = when(myGreeting){
        null -> "Hi"
        else -> myGreeting
    }
    println(greetingToPrint)

    //Functions
    println(getGreeting())
    sayHello()
}
