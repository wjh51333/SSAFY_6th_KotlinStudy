package today4

lateinit var dp: Array<Long>
fun main() {
    val (N, P, Q) = readLine()!!.split(" ").map { it.toLong() }
    dp = Array(100000) { 0L }
    dp[0] = 1
    for (i in 1 until dp.size) {
        dp[i] = dp[((i / P).toInt())] + dp[((i / Q).toInt())]
    }
    print(DP(N, P, Q))
}

fun DP(N: Long, P: Long, Q: Long): Long {
    if (N < 100000) {
        return dp[N.toInt()]
    }
    return DP(N / P, P, Q) + DP(N / Q, P, Q)
}