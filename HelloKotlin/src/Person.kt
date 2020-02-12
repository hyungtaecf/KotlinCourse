/*
class Person(_firstName: String, _lastName: String){
    val firstName: String = _firstName
    val lastName:String = _lastName
}
*/

/*
class Person(val firstName: String, val lastName: String){
    //Init blocks always are gonna run before the secondary constructor
    init{
        println("init 1")
    }
    constructor(): this("Peter","Parker"){
        println("Secondary Constructor")
    }
    init{
        println("init 2")
    }
}
*/

//classes are public as default
class Person(val firstName: String = "Peter", val lastName: String = "Parker"){
    protected var protectedAtribute: String = "" //Available within this class or subclasses
    private var provateAtribute: String = "" //Available only within this class

    var nickname: String? = null
        set(value) {
            field = value
            println("The new nickname is $value")
        }
        get() {
//            println("The returned value is $field")
            return field
        }

    fun printInfo(){
        val nicknameToPrint = nickname ?: "no nickname" // Elvis Operator
            //== val nicknameToPrint = if(nickname!=null) nickname else "no nickname"
        println("$firstName ($nicknameToPrint) $lastName")
    }
}

internal class InternalClass //Available within the module

private class PrivateClass //Available within the file it is implemented