import java.util.*

val MAX = 100001
val move = arrayOf(-1, 1, 2)

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine(), " ")
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    println(solve(n, k))
}

private fun solve(n : Int, k : Int) : Int {
    if (n == k) return 0
    val dist = IntArray(MAX) { i -> -1 }
    val q : Queue<Int> = LinkedList()
    q.add(n)
    dist[n] = 0

    while (q.isNotEmpty()) {
        val now = q.poll()

        if (now == k) return dist[now]

        for (d in move) {
            val next : Int
            if (d == 2) next = now * d
            else next = now + d

            if (next in 0 until MAX && dist[next] == -1) {
                dist[next] = dist[now] + 1
                q.add(next)
            }
        }
    }
    return MAX
}