import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())

    for (x in 1..n) {
        val input = readLine().toInt()
        if (input == 0) {
            if (pq.isEmpty()) bw.write("0\n")
            else bw.write("${pq.poll()}\n")
        } else {
            pq.add(input)
        }
    }
    bw.flush()
}