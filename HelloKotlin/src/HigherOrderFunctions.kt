//fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean){ //it means predicate is a variable of the data type function that takes a String and returns a Boolean
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?){ //now predicate is nullable
    list.forEach{
        /*if(predicate(it)){//If predicate returns true
            println(it) //returns string
        }*/
        //if it is nullable, you need to use the invoke
        if(predicate?.invoke(it) == true){//If predicate returns true
            println(it) //returns string
        }
    }
}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

//Example of function that return other function
fun getPrintPredicate(): (String) -> Boolean {
    return{ it.startsWith("J") }
}

fun main(){
    val list = listOf("")
    //If the last parameter of a function is a function, you can specify with a lambda expression
//    printFilteredStrings(list){
//        it.startsWith("J")
//    }

//    printFilteredStrings(list, predicate)//using the function as variables

    printFilteredStrings(list, getPrintPredicate())

    printFilteredStrings(list, null)
}