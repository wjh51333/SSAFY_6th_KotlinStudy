import java.util.*;

fun main() {
    //우선순위 큐 java.util import
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    for (i in 0 until readLine()!!.toInt()) {
        val temp = readLine()!!.toInt()
        if (pq.isNotEmpty() && temp == 0) println(pq.poll()) else if (pq.isEmpty() && temp == 0) println(0) else pq += temp
    }
}