import kotlin.system.exitProcess

fun main() {
    println("Виберіть операцію:")
    println("1. Перевірити чи число парне чи ні")
    println("2. Помножити число на 4, якщо воно парне, і на 5, якщо воно не парне")
    println("3. Повернути від'ємне число")
    println("4. Визначити вік за роком народження")
    println("5. Знайти мінімальне число в масиві")
    println("6. Знайти два найбільших числа в масиві")
    println("7. Порахувати кількість позитивних чисел і суму негативних чисел у масиві")
    println("8. Порахувати кількість голосних букв у рядку")
    println("9. Знайти середній символ у рядку")
    println("10. Створити таблицю множення")

    val choice = readLine()?.toIntOrNull()

    when (choice) {
        1 -> {
            println("Введіть число:")
            val number = readLine()?.toIntOrNull()
            if (number != null) {
                println(getEvenOrOdd(number))
            } else {
                println("Некоректне введення числа.")
            }
        }
        2 -> {
            println("Введіть число:")
            val number = readLine()?.toIntOrNull()
            if (number != null) {
                println(multiplyByFourOrFive(number))
            } else {
                println("Некоректне введення числа.")
            }
        }
        3 -> {
            println("Введіть число:")
            val number = readLine()?.toIntOrNull()
            if (number != null) {
                println(getNegativeNumber(number))
            } else {
                println("Некоректне введення числа.")
            }
        }
        4 -> {
            println("Введіть рік:")
            val year = readLine()?.toIntOrNull()
            if (year != null) {
                println(calculateAge(year))
            } else {
                println("Некоректне введення року.")
            }
        }
        5 -> {
            println("Введіть числа через пробіл:")
            val input = readLine()
            val numbers = input?.split(" ")?.map { it.toIntOrNull() }
            if (numbers != null && numbers.all { it != null }) {
                println(findMinimum(numbers.filterNotNull()))
            } else {
                println("Некоректне введення чисел.")
            }
        }
        6 -> {
            println("Введіть числа через пробіл:")
            val input = readLine()
            val numbers = input?.split(" ")?.map { it.toIntOrNull() }
            if (numbers != null && numbers.all { it != null }) {
                println(findTwoLargest(numbers.filterNotNull()))
            } else {
                println("Некоректне введення чисел.")
            }
        }
        7 -> {
            println("Введіть числа через пробіл:")
            val input = readLine()
            val numbers = input?.split(" ")?.map { it.toIntOrNull() }
            if (numbers != null && numbers.all { it != null }) {
                println(countPositiveAndNegative(numbers.filterNotNull()))
            } else {
                println("Некоректне введення чисел.")
            }
        }
        8 -> {
            println("Введіть рядок:")
            val str = readLine()
            if (!str.isNullOrBlank()) {
                println(countVowels(str))
            } else {
                println("Рядок не може бути порожнім.")
            }
        }
        9 -> {
            println("Введіть рядок:")
            val str = readLine()
            if (!str.isNullOrBlank()) {
                println(findMiddleCharacter(str))
            } else {
                println("Рядок не може бути порожнім.")
            }
        }
        10 -> {
            println("Введіть розмір таблиці:")
            val n = readLine()?.toIntOrNull()
            if (n != null) {
                println(createMultiplicationTable(n))
            } else {
                println("Некоректне введення розміру таблиці.")
            }
        }
        else -> {
            println("Некоректний вибір.")
            exitProcess(1)
        }
    }
}

fun getEvenOrOdd(number: Int): String {
    return if (number % 2 == 0) "Even" else "Odd"
}

fun multiplyByFourOrFive(number: Int): Int {
    return if (number % 2 == 0) number * 4 else number * 5
}

fun getNegativeNumber(number: Int): Int {
    return -number
}

fun calculateAge(year: Int): Int {
    return 2024-year
}

fun findMinimum(numbers: List<Int>): Int {
    return numbers.minOrNull() ?: 0
}

fun findTwoLargest(numbers: List<Int>): List<Int> {
    val sortedNumbers = numbers.sorted()
    return sortedNumbers.subList(sortedNumbers.size - 2, sortedNumbers.size).reversed()
}

fun countPositiveAndNegative(numbers: List<Int>): List<Int> {
    if (numbers.isEmpty()) return emptyList()
    val positiveCount = numbers.count { it > 0 }
    val negativeSum = numbers.filter { it < 0 }.sum()
    return listOf(positiveCount, negativeSum)
}

fun countVowels(str: String): Int {
    val vowels = "aeiouy"
    return str.count { it.toLowerCase() in vowels }
}

fun findMiddleCharacter(str: String): String {
    val middleIndex = str.length / 2
    return if (str.length % 2 == 0) str.substring(middleIndex - 1, middleIndex + 1) else str.substring(middleIndex, middleIndex + 1)
}

fun createMultiplicationTable(n: Int): List<List<Int>> {
    return List(n) { i ->
        List(n) { j ->
            (i + 1) * (j + 1)
        }
    }
}
