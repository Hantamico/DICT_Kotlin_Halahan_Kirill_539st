import kotlin.system.exitProcess

fun greet(): String {
    println("Hello! My name is DICT_Bot.")
    println("Please, remind me your name.")
    println(">")
    val name = readLine()!!
    println("What a great name you have, $name!")
    return name
}

fun guessAge() {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    println(">")
    val remainder3 = readLine()!!.toInt()
    println(">")
    val remainder5 = readLine()!!.toInt()
    println(">")
    val remainder7 = readLine()!!.toInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    println("Your age is $age!")
}

fun count() {
    println("Now I will prove to you that I can count to any number you want.")
    println(">")
    val num = readLine()!!.toInt()
    for (i in 0..num) {
        println("$i!")
    }
}

fun test() {
    println("Let's test your programming knowledge.")
    println("Why do we use methods?")
    println("1. To repeat a statement multiple times.")
    println("2. To decompose a program into several small subroutines.")
    println("3. To determine the execution time of a program.")
    println("4. To interrupt the execution of a program.")
    while (true) {
        println(">")
        val answer = readLine()!!
        if (answer == "2") {
            break
        } else {
            println("Please, try again.")
        }
    }
    println("Congratulations, have a nice day!")
}
fun main() {
    val name = greet()
    guessAge()
    count()
    test()
    exitProcess(0)
}
