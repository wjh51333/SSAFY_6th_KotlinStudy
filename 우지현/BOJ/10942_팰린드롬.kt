fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { i -> IntArray(n) { j -> if (i == j) 1 else 0 } }

    for (i in 0 until n - 1) {
        if (arr[i] == arr[i + 1])
            dp[i][i + 1] = 1
    }

    for (k in 3..n) {
        for (s in 0..n - k) {
            if (dp[s + 1][s + k - 2] == 1 && arr[s] == arr[s + k - 1])
                dp[s][s + k - 1] = 1
        }
    }

    val m = readLine().toInt()
    for (i in 0 until m) {
        val (s, e) = readLine().split(" ").map { it.toInt() - 1 }
        bw.write("${dp[s][e]}\n")
    }
    bw.flush()
}