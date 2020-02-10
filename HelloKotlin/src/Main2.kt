fun sayHello(greeting: String, itemToGreet:String) = println("$greeting $itemToGreet") //== "Hello " + itemToGreet

fun sayHelloList(greeting: String, itemsToGreet:List<String>){
    itemsToGreet.forEach { itemToGreet ->
        println("$greeting $itemToGreet")
    }
}

fun main(){
    sayHello(greeting = "Hello", itemToGreet = "Kotlin")
    sayHello(greeting = "Hello", itemToGreet = "World")

    //Array
    val interestingThings = arrayOf("Kotlin", "Programming", "Comic Books")
    println(interestingThings.size)
    println(interestingThings[0])//== println(interestingThings.get(0))

    //for
    for (interestingThing in interestingThings){
        println(interestingThing)
    }

    //forEach
    interestingThings.forEach {
        println(it)
    }
        //==
    interestingThings.forEach {interestingThing ->
        println(interestingThing)
    }
    interestingThings.forEachIndexed{ index, interestingThing ->
        println("$interestingThing is at index $index")
    }

    //List --> They are immutable
    val interestingThingsList = listOf("Kotlin", "Programming", "Comic Books")
    interestingThingsList.forEach {
        println(it)
    }

    //Map --> They are immutable
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach { key, value -> println("$key -> $value") }

    //Mutable List
    val interestingThingsMutableList = mutableListOf("Kotlin", "Programming", "Comic Books")
    interestingThingsMutableList.add("Dogs")
    interestingThingsMutableList.forEach {
        println(it)
    }

    //Mutable Map
    val mutableMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    mutableMap.put(4, "d")
    mutableMap.forEach { key, value -> println("$key -> $value") }

    //Function with List
    sayHelloList("Hi", itemsToGreet = interestingThingsMutableList)
}