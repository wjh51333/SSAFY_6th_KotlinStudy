fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val wv = Array(n) { readLine().split(" ").map { it.toInt() } } // w, v
    val dp = Array(n + 1) { IntArray(k + 1) }

    for (i in 1..n) {
        for (j in 1..k) {
            dp[i][j] = dp[i - 1][j]

            val (w, v) = wv[i - 1]
            if (w <= j) { // 해당 물건을 넣을 수 있는 경우
                dp[i][j] = maxOf(dp[i - 1][j], dp[i - 1][j - w] + v)
            }
        }
    }
    print(dp[n][k])
}