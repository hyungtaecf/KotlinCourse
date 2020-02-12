interface PersonInfoProvider{
    //In Kotlin, you can provide properties on the interfaces as well as methods
    val providerInfo: String //You can't initialize properties in interfaces, you have to override it later

    fun printInfo(person: Person){
        //In Kotlin, Interfaces can provide default implementation of an Interface method
        println("basicInfoProvider")
        person.printInfo()
    }
}

interface SessionInfoProvider{
    fun getSessionId(): String
}


//Abstract Class
//  It means it doesn't need to implement all the methods available in the interface, but it also can't also be instantiated
//abstract class BasicInfoProvider: PersonInfoProvider


//In Kotlin, by default classes are closed, it means they cannot be inherited from or extended
// You need to add the keyword open to the class in order to extend it

open class BasicInfoProvider: PersonInfoProvider, SessionInfoProvider{
    override val providerInfo: String
        get() = "BasicInfoProvider"

    //Like the class, if you want to open the properties to be modified in a sub-class
    // so you need to use the "open" keyword
    //If you want it to be available for the child classes, but not the main API, so use protected keyword
    protected open val sessionIdPrefix = "Session"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}


fun main(){
//    val provider = BasicInfoProvider()
    val provider = FancyInfoProvider()

    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
}

//How to check if it implements some interface: "is" keyword
fun checkTypes(infoProvider: PersonInfoProvider){
    if(infoProvider is SessionInfoProvider){ //to check the opposite use !is
        println("is a session info provider")
//        (infoProvider as SessionInfoProvider).getSessionId() //Casting (as keyword): to access properties or methods of a specific interface
//  But in Kotlin it has a smart casting: if the compiler can check the type and can validate that type will not change, so you don't need to recast it
        infoProvider.getSessionId()
    } else{
        println("not a session info provider")
    }
}