import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val jumps = Array(n+1) { arrayOf(0, 0) }
    for (i in 1 until n) {
        val input = readLine()!!.split(" ")
        jumps[i] = arrayOf(input[0].toInt(), input[1].toInt())
    }
    val k = readLine()!!.toInt()

    val dp = Array(n+1) { Array<Int>(2){ 100_001 } }
    dp[1][0] = 0
    dp[1][1] = 0

    for (i in 1 until n) {
        dp[i+1][0] = min(dp[i+1][0], dp[i][0] + jumps[i][0])
        dp[i+1][1] = min(dp[i+1][1], dp[i][1] + jumps[i][0])

        if (i+2 <= n) {
            dp[i+2][0] = min(dp[i+2][0], dp[i][0] + jumps[i][1])
            dp[i+2][1] = min(dp[i+2][1], dp[i][1] + jumps[i][1])
        }

        if (i+3 <= n)
            dp[i+3][1] = min(dp[i+3][1], dp[i][0] + k)
    }

    println(dp[n].minOf { it })
}