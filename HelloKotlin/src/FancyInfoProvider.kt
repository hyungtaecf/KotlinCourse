//Inheritance


class FancyInfoProvider : BasicInfoProvider(){
    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override val providerInfo: String
        get() = "FancyInfoProvider"
    //TODO não está fazendo override, entender qual é o problema (momento 1:39:00)

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Fancy Info")
    }
}