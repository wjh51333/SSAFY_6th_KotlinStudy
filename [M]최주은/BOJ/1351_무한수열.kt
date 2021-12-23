package boj.`1351_무한수열`

val map = HashMap<Long, Long>()
var P = 0L
var Q = 0L

fun main() {
    val (N, p, q) = readLine()!!.trim().split(" ").map { it.toLong() }
    P = p
    Q = q

    map[0] = 1
    map[1] = 2

    print(dfs(N))
}

fun dfs(n:Long) : Long{
    if (n == 0L) return 1
    if (map[n] != null) return map[n]!!.toLong()

    map[n] = dfs(n/P) + dfs(n/Q)
    return map[n]!!.toLong()
}
