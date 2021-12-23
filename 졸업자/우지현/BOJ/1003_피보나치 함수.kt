fun main() {
    val T = readLine()!!.toInt()
    for (i in 1..T) {
        val result = solve(readLine()!!.toInt())
        println("${result.first} ${result.second}")
    }
}

fun solve(n : Int) : Pair<Int, Int> {
    if (n == 0) return Pair(1, 0)
    if (n == 1) return Pair(0, 1)

    val dp = IntArray(n + 1) { i -> 1 }
    dp[n] = 1
    dp[n - 1] = 1

    for (x in n - 2 downTo 0) {
        dp[x] = dp[x + 1] + dp[x + 2]
    }
    return Pair(dp[0] - dp[1], dp[1])
}