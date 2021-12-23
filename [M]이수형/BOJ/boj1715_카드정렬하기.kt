import java.util.*

fun main() {
    var N = readLine()!!.toInt()
    var q = PriorityQueue<Int>()
    repeat(N) { q.add(readLine()!!.toInt()) }
    var total = 0
    while (q.size != 1) {
        var sum = q.poll() + q.poll()
        total += sum
        q.add(sum)
    }
    println(total)
}