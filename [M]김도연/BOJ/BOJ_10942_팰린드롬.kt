fun main() {
    val n = readLine()!!.toInt()
    val input = readLine()!!.split(" ")

    val arr = Array(n+1) { 0 }
    for (i in 1..n)
        arr[i] = input[i-1].toInt()

    val dp = Array(n+1) { Array(n+1) { false } }
    for (i in 1..n) {
        dp[i][i] = true
        if (i != n && arr[i] == arr[i+1])
            dp[i][i+1] = true
    }

    for (len in 3..n) {
        for (s in 1..(n-len+1)) {
            val e = s+len-1
            if (arr[s] == arr[e] && dp[s+1][e-1])
                dp[s][e] = true
        }
    }

    val sb = StringBuffer()
    val m = readLine()!!.toInt()
    for (i in 1..m) {
        val input = readLine()!!.split(" ")
        val s = input[0].toInt()
        val e = input[1].toInt()
        sb.append(if (dp[s][e]) 1 else 0).append("\n")
    }

    print(sb.toString())
}