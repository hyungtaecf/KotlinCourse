fun main(){
    val list = listOf("Kotlin", "Java", "C++", "Javascript", null, null)
//    list
//        .filterNotNull() // Filter to take out the nulls
////        .filter{ // Example of basic filter to take just the words that start with J
////            it.startsWith("J")
////        }
////        .map{ //Example that transforms the String to an Integer that represents the length of each word
////            it.length
////        }
////        .take(3) //Example to take just the first 3 elements
////        .takeLast(3) //Example to take just the last 3 elements
//        //Example that maps the string to the number of characters in that string
//        .associate{it to it.length}
//        .forEach{
//        //print(it)
//            println("${it.value}, ${it.key}")
//    }

    val map = list
        .filterNotNull()
        .associate { it to it.length }

    var language = list.filterNotNull().findLast{it.startsWith("Java")}
    println(language)
    language = list.filterNotNull().findLast{it.startsWith("foo")}//Returns null if there is no matches
    println(language)
    language = list.filterNotNull().findLast{it.startsWith("foo")}.orEmpty()//Returns a empty string if there is no matches
    println(language)
}