class QueueImpl<T : Any> : Queue<T> {

    private val list = ArrayList<T>()

     fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

     fun dequeue(): T? {
        return if (list.isEmpty()) {
            null
        } else {
            list.removeAt(0)
        }
    }

     val count: Int
        get() = list.size

     val isEmpty: Boolean
        get() = list.isEmpty()

     fun peek(): T? {
        return if (list.isEmpty()) {
            null
        } else {
            list[0]
        }
    }
}

interface Queue<T> {

}

fun main() {
    val queue = QueueImpl<Int>()

    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    println(queue.count) // 3

    val element = queue.dequeue()
    println(element) // 1

    println(queue.isEmpty) // false

    val peekedElement = queue.peek()
    println(peekedElement) // 2

    queue.dequeue()
    queue.dequeue()

    println(queue.isEmpty) // true
}