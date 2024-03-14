import kotlin.random.Random

fun main() {
    val options = listOf("Камінь", "Ножиці", "Папір")
    val computerChoice = options[Random.nextInt(options.size)]

    println("Привіт! Граємо у Камінь-ножиці-папір.")
    println("Виберіть свій варіант: Камінь, Ножиці або Папір:")
    val userChoice = readLine()

    if (userChoice !in options) {
        println("Ви ввели некоректний варіант. Спробуйте ще раз.")
        return
    }

    println("Комп'ютер обрав: $computerChoice")
    println("Ви обрали: $userChoice")

    val result = determineWinner(userChoice, computerChoice)
    when {
        result == 0 -> println("Нічия!")
        result > 0 -> println("Ви виграли!")
        else -> println("Ви програли.")
    }
}

fun determineWinner(userChoice: String?, computerChoice: String): Int {
    if (userChoice == null) return -1

    return when {
        userChoice == computerChoice -> 0
        userChoice == "Камінь" && computerChoice == "Ножиці" ||
                userChoice == "Ножиці" && computerChoice == "Папір" ||
                userChoice == "Папір" && computerChoice == "Камінь" -> 1
        else -> -1
    }
}