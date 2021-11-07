import java.util.*

fun main() {
    val pq = PriorityQueue<Long>()
    val n = readLine()!!.toInt()

    for (i in 1..n)
        pq.add(readLine()!!.toLong())

    if (n == 1) {
        println(0)
    } else {
        var sum = 0L
        while (pq.size > 1) {
            val card = pq.remove() + pq.remove()
            sum += card
            pq.add(card)
        }
        println(sum)
    }
}