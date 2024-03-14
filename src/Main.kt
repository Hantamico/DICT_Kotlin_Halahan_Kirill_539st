// 1. На вході ціле число, повернути рядок “Even” для парного числа та “Odd” в іншому випадку.
fun getEvenOrOdd(number: Int): String {
    return if (number % 2 == 0) "Even" else "Odd"
}

// 2. Помножити задане число на 4, якщо воно парне і на 5 інакше.
fun multiplyByFourOrFive(number: Int): Int {
    return if (number % 2 == 0) number * 4 else number * 5
}

// 3. Повернути негативне число.
fun getNegativeNumber(number: Int): Int {
    return -number
}

// 4. За роком визначити вік.
fun calculateAge(year: Int): Int {
    return ((year - 1) / 100) + 1
}

// 5. Задано масив цілих чисел, котрому необхідно визначити найменше ціле число.
fun findMinimum(numbers: List<Int>): Int {
    return numbers.minOrNull() ?: 0
}

// 6. Задано масив цілих чисел, для якого потрібно знайти два найбільші числа.
fun findTwoLargest(numbers: List<Int>): List<Int> {
    val sortedNumbers = numbers.sorted()
    return sortedNumbers.subList(sortedNumbers.size - 2, sortedNumbers.size).reversed()
}

// 7. Даний масив цілих чисел, котрому повернути масив, де перший елемент є кількістю позитивних чисел, а другий – сумою негативних чисел.
fun countPositiveAndNegative(numbers: List<Int>): List<Int> {
    if (numbers.isEmpty()) return emptyList()
    val positiveCount = numbers.count { it > 0 }
    val negativeSum = numbers.filter { it < 0 }.sum()
    return listOf(positiveCount, negativeSum)
}

// 8. Порахувати кількість голосних букв у рядку (a, e, i, o, u, y голосні).
fun countVowels(str: String): Int {
    val vowels = "aeiouy"
    return str.count { it.toLowerCase() in vowels }
}

// 9. Дано рядок, для якого необхідно знайти середній символ.
fun findMiddleCharacter(str: String): String {
    val middleIndex = str.length / 2
    return if (str.length % 2 == 0) str.substring(middleIndex - 1, middleIndex + 1) else str.substring(middleIndex, middleIndex + 1)
}

// 10. Створити таблицю множення розміром NxN.
fun createMultiplicationTable(n: Int): List<List<Int>> {
    return List(n) { i -> List(n) { j -> (i + 1) * (j + 1) } }
}
fun main() {
    fun main() {
        println(getEvenOrOdd(5)) // Поверне "Odd"
        println(multiplyByFourOrFive(6)) // Поверне 24
        println(getNegativeNumber(5)) // Поверне -5
        println(calculateAge(2024)) // Поверне 1
        println(findMinimum(listOf(34, 15, 88, 2))) // Поверне 2
        println(findTwoLargest(listOf(1, 5, 87, 45, 8, 8))) // Поверне [45, 87]
        println(countPositiveAndNegative(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15))) // Поверне [10, -65]
        println(countVowels("Hello")) // Поверне 2
        println(findMiddleCharacter("student")) // Поверне "d"
        println(createMultiplicationTable(3)) // Поверне [[1, 2, 3], [2, 4, 6], [3, 6, 9]]
    }
}