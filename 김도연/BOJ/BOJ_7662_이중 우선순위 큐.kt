import java.util.*
import kotlin.collections.HashMap

fun main() {
    val sc = Scanner(System.`in`)

    val t = sc.nextInt()

    for (tc in 1..t) {
        val k = sc.nextInt()
        sc.nextLine()
        val minQ = PriorityQueue<Int>()
        val maxQ = PriorityQueue<Int>(reverseOrder())
        var size = 0
        var map = HashMap<Int, Int>()

        for (i in 1..k) {
            val input = sc.nextLine().split(" ")
            if (input[0] == "I") {
                minQ.add(input[1].toInt())
                maxQ.add(input[1].toInt())
                map[input[1].toInt()] = map.getOrDefault(input[1].toInt(), 0) + 1
                size++
            } else if (input[0] == "D") {
                if (size == 0)
                    continue
                else if (input[1] == "1") {
                    while (map[maxQ.peek()] == 0)
                        maxQ.remove()
                    val max = maxQ.remove()
                    map[max] = map[max]!! - 1
                    size--
                } else {
                    while (map[minQ.peek()] == 0)
                        minQ.remove()
                    val min = minQ.remove()
                    map[min] = map[min]!! - 1
                    size--
                }
            }
        }
        if (size == 0)
            println("EMPTY")
        else {
            while (map[maxQ.peek()] == 0)
                maxQ.remove()
            while (map[minQ.peek()] == 0)
                minQ.remove()
            println("${maxQ.peek()} ${minQ.peek()}")
        }
    }
}


fun fail() {
    val k = readLine()!!.toInt()

    val queue = PriorityQueue<Int>()
    for (i in 1..k) {
        val input = readLine()!!.split(" ")
        if (input[0] == "I") {
            queue.add(input[1].toInt())
        } else if (input[0] == "D") {
            if (queue.size == 0)
                continue
            else if (input[1] == "1") {
                val max = queue.maxOf { it }
                queue.remove(max)
            } else {
                val min = queue.minOf { it }
                queue.remove(min)
            }
        }
    }

    if (queue.size == 0)
        println("EMPTY")
    else
        println("${queue.maxOf { it }} ${queue.minOf { it }}")
}