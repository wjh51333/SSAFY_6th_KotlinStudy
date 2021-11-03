package today

import java.lang.StringBuilder

lateinit var dp: Array<Array<Boolean>>
lateinit var st: Array<Int>
var N: Int = 0
fun main() {
    var sb = StringBuilder()
    N = readLine()!!.toInt()
    var temp = readLine()!!.split(" ")
    st = Array(N + 1) { if (it != 0) temp[it - 1].toInt() else 0 }
    dp = Array(N + 1) { Array(N + 1) { false } }

    for (i in 1..N) {
        dp[i][i] = true
    }

    for (i in 1 until N) {
        if (st[i] == st[i + 1]) {
            dp[i][i + 1] = true
        }
    }

    for (i in 2 until N) {
        for (j in 1..N - i) {
            if (st[j] == st[j + i] && dp[j + 1][j + i - 1]) {
                dp[j][j + i] = true
            }
        }
    }
//    for (i in 1..N) {
//        for (j in 1..N) {
//            print("${dp[i][j]} ")
//        }
//        println()
//    }


    for (i in 0 until readLine()!!.toInt()) {
        var idx = readLine()!!.split(" ")
        sb.append(if (dp[idx[0].toInt()][idx[1].toInt()]) "1\n" else "0\n")
    }
    println(sb)
}

