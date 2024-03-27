// Клас, який представляє кавоварку
class CoffeeMachine(
    var water: Int = 400,
    var milk: Int = 540,
    var coffeeBeans: Int = 120,
    var disposableCups: Int = 9,
    var money: Int = 550
) {
    // Метод для відображення ресурсів кавоварки
    fun displayResources() {
        print("The coffee machine has:")
        print("$water of water")
        print("$milk of milk")
        print("$coffeeBeans of coffee beans")
        print("$disposableCups of disposable cups")
        print("$money of money")
    }

    // Метод для покупки кави
    fun buyCoffee() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        print(">")
        when (readLine()) {
            "1" -> makeCoffee(250, 0, 16, 4)
            "2" -> makeCoffee(350, 75, 20, 7)
            "3" -> makeCoffee(200, 100, 12, 6)
            "back" -> return
            else -> print("Invalid choice!")
        }
    }

    // Приватний метод для виготовлення кави
    private fun makeCoffee(waterNeeded: Int, milkNeeded: Int, beansNeeded: Int, cost: Int) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= beansNeeded && disposableCups >= 1) {
            print("I have enough resources, making you a coffee!")
            water -= waterNeeded
            milk -= milkNeeded
            coffeeBeans -= beansNeeded
            disposableCups--
            money += cost
        } else {
            print("Sorry, not enough resources!")
        }
    }

    // Метод для наповнення кавоварки ресурсами
    fun fillMachine() {
        do {
            print("Write how many ml of water do you want to add:")
            print(">")
            val addedWater = readLine()?.toIntOrNull()
            if (addedWater != null && addedWater > 0) {
                water += addedWater
                break
            } else {
                println("Invalid input. Please enter a positive integer.")
            }
        } while (true)

        do {
            print("Write how many ml of milk do you want to add:")
            print(">")
            val addedMilk = readLine()?.toIntOrNull()
            if (addedMilk != null && addedMilk > 0) {
                milk += addedMilk
                break
            } else {
                println("Invalid input. Please enter a positive integer.")
            }
        } while (true)

        do {
            print("Write how many grams of coffee beans do you want to add:")
            print(">")
            val addedBeans = readLine()?.toIntOrNull()
            if (addedBeans != null && addedBeans > 0) {
                coffeeBeans += addedBeans
                break
            } else {
                println("Invalid input. Please enter a positive integer.")
            }
        } while (true)

        do {
            print("Write how many disposable cups of coffee do you want to add:")
            print(">")
            val addedCups = readLine()?.toIntOrNull()
            if (addedCups != null && addedCups > 0) {
                disposableCups += addedCups
                break
            } else {
                println("Invalid input. Please enter a positive integer.")
            }
        } while (true)
    }

    // Метод для взяття грошей з кавоварки
    fun takeMoney() {
        print("I gave you $money")
        money = 0
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()

    while (true) {
        print("Write action (buy, fill, take, remaining, exit):")
        print(">")
        when (readLine()) {
            "buy" -> coffeeMachine.buyCoffee()
            "fill" -> coffeeMachine.fillMachine()
            "take" -> coffeeMachine.takeMoney()
            "remaining" -> coffeeMachine.displayResources()
            "exit" -> return
            else -> print("Invalid action!")
        }
    }
}