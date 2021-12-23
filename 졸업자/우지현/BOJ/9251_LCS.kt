fun main() = with(System.`in`.bufferedReader()) {
    val a = '0' + readLine()
    val b = '0' + readLine()
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }

    for (i in 1 until a.length) {
        for (j in 1 until b.length) {
            if (a[i] == b[j])
                dp[i][j] = dp[i - 1][j - 1] + 1
            else
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
        }
    }
    print(dp[a.length - 1][b.length - 1])
}