package today4

fun main() {
    val str1 = readLine()!!.toCharArray()
    val str2 = readLine()!!.toCharArray()
    val dp = Array(str1.size + 1) { IntArray(str2.size + 1) }
    for (i in 1..str1.size) {
        for (j in 1..str2.size) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = dp[i - 1][j].coerceAtLeast(dp[i][j - 1])
            }
        }
    }

    println(dp[str1.size][str2.size])
}
