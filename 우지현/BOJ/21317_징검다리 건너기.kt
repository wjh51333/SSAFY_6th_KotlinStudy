private var n = 0
private var k = 0
private var energy = arrayOf<IntArray>()
private var dp = arrayOf<IntArray>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    energy = Array<IntArray>(n - 1) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    k = readLine().toInt()
    dp = Array<IntArray>(n) { IntArray(2) { 100000 } }
    dp[0][0] = 0
    dp[0][1] = 0
    go(0, 0)
    println(minOf(dp[n - 1][0], dp[n - 1][1]))
}

private fun go(now : Int, flag : Int) {
    if (now == n - 1) return

    if (now + 1 < n) { // 작은 점프
        dp[now + 1][flag] = minOf(dp[now + 1][flag], dp[now][flag] + energy[now][0])
        go(now + 1, flag)
    }
    if (now + 2 < n) { // 큰 점프
        dp[now + 2][flag] = minOf(dp[now + 2][flag], dp[now][flag] + energy[now][1])
        go(now + 2, flag)
    }
    if (flag == 0 && now + 3 < n) { // 매우 큰 점프는 한 번만 가능함
        dp[now + 3][1] = minOf(dp[now + 3][1], dp[now][flag] + k)
        go(now + 3, 1)
    }
}

