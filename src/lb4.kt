import kotlin.math.ceil

class Cinema(rows: Int, seatsPerRow: Int) {
    private val seats: Array<Array<String>> = Array(rows) { Array(seatsPerRow) { "S" } }
    private val totalSeats = rows * seatsPerRow
    private var currentIncome = 0
    private val totalIncome = calculateTotalIncome(rows, seatsPerRow)

    fun showMenu() {
        while (true) {
            println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
            when (readLine()!!.toInt()) {
                1 -> showSeats()
                2 -> buyTicket()
                3 -> showStatistics()
                0 -> return
            }
        }
    }

    private fun showSeats() {
        println("\nCinema:")
        print(" ")
        repeat(seats[0].size) { print("${it + 1} ") }
        println()
        for ((index, row) in seats.withIndex()) {
            print("${index + 1}")
            for (seat in row) {
                print(" $seat")
            }
            println()
        }
    }

    private fun buyTicket() {
        while (true) {
            println("\nEnter a row number:")
            val row = readLine()!!.toInt()
            println("Enter a seat number in that row:")
            val seat = readLine()!!.toInt()

            if (row !in 1..seats.size || seat !in 1..seats[0].size) {
                println("Wrong input!")
                continue
            }

            if (seats[row - 1][seat - 1] == "B") {
                println("That ticket has already been purchased!")
                continue
            }

            val ticketPrice = calculateTicketPrice(row)
            println("\nTicket price: $$ticketPrice")
            seats[row - 1][seat - 1] = "B"
            currentIncome += ticketPrice
            break
        }
    }

    private fun calculateTicketPrice(row: Int): Int {
        return if (totalSeats <= 60 || row <= seats.size / 2) {
            10
        } else {
            8
        }
    }

    private fun calculateTotalIncome(rows: Int, seatsPerRow: Int): Int {
        return if (rows * seatsPerRow <= 60) {
            rows * seatsPerRow * 10
        } else {
            val frontHalfRows = ceil(rows.toDouble() / 2).toInt()
            val backHalfRows = rows - frontHalfRows
            (frontHalfRows * seatsPerRow * 10) + (backHalfRows * seatsPerRow * 8)
        }
    }

    private fun showStatistics() {
        val purchasedTickets = seats.sumBy { row -> row.count { it == "B" } }
        val percentage = purchasedTickets.toDouble() / totalSeats * 100
        println("\nNumber of purchased tickets: $purchasedTickets")
        println("Percentage: %.2f%%".format(percentage))
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
    }
}

fun main() {
    println("Enter the number of rows:")
    val rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readLine()!!.toInt()

    val cinema = Cinema(rows, seatsPerRow)
    cinema.showMenu()
}