class CoffeeMachine(
    var water: Int = 400,
    var milk: Int = 540,
    var coffeeBeans: Int = 120,
    var disposableCups: Int = 9,
    var money: Int = 550
) {
    fun displayResources() {
        println("The coffee machine has:")
        println("$water of water")
        println("$milk of milk")
        println("$coffeeBeans of coffee beans")
        println("$disposableCups of disposable cups")
        println("$money of money")
    }

    fun buyCoffee() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        println(">")
        when (readLine()) {
            "1" -> makeCoffee(250, 0, 16, 4)
            "2" -> makeCoffee(350, 75, 20, 7)
            "3" -> makeCoffee(200, 100, 12, 6)
            "back" -> return
            else -> println("Invalid choice!")
        }
    }

    private fun makeCoffee(waterNeeded: Int, milkNeeded: Int, beansNeeded: Int, cost: Int) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= beansNeeded && disposableCups >= 1) {
            println("I have enough resources, making you a coffee!")
            water -= waterNeeded
            milk -= milkNeeded
            coffeeBeans -= beansNeeded
            disposableCups--
            money += cost
        } else {
            println("Sorry, not enough resources!")
        }
    }

    fun fillMachine() {
        println("Write how many ml of water do you want to add:")
        println(">")
        water += readLine()?.toIntOrNull() ?: 0
        println("Write how many ml of milk do you want to add:")
        println(">")
        milk += readLine()?.toIntOrNull() ?: 0
        println("Write how many grams of coffee beans do you want to add:")
        println(">")
        coffeeBeans += readLine()?.toIntOrNull() ?: 0
        println("Write how many disposable cups of coffee do you want to add:")
        println(">")
        disposableCups += readLine()?.toIntOrNull() ?: 0
    }

    fun takeMoney() {
        println("I gave you $money")
        money = 0
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()

    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        println(">")
        when (readLine()) {
            "buy" -> coffeeMachine.buyCoffee()
            "fill" -> coffeeMachine.fillMachine()
            "take" -> coffeeMachine.takeMoney()
            "remaining" -> coffeeMachine.displayResources()
            "exit" -> return
            else -> println("Invalid action!")
        }
    }
}