package today3

import java.util.*

data class node(var money: Int, var day: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine()!!.toInt()
    val check = Array(10001) { false }
    val lambda = { a: Int, b: Int ->
        when {
            a < b -> 1
            a > b -> -1
            else -> 0
        }
    }
    val q = PriorityQueue<node> { a, b ->
        when {
            a.money == b.money -> lambda(a.day, b.day)
            else -> lambda(a.money, b.money)
        }
    }
    var total = 0
    for (i in 0 until N) {
        val temp = readLine().split(" ").map { it.toInt() }
        q.add(node(temp[0], temp[1]))
    }
    while (q.isNotEmpty()) {
        val n = q.poll();
        while (n.day > 0) {
            if (!check[n.day]) {
                check[n.day] = true
                total += n.money
                break;
            }
            n.day--
        }
    }
    print(total)
}
