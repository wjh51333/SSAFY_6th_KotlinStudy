package boj.`10942_팰린드룸`

/**
 * [참고]
 * https://4z7l.github.io/2021/04/07/algorithms-boj-10942.html
 * => 왜 DP 문제인지?
 * => 과정 이해 필요
 */

import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))
val N = br.readLine().toInt()
val num = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
val M = br.readLine().toInt()
val p = Array(N) { a -> Array(N) { b -> a==b } }

fun main() = with(System.`out`.bufferedWriter()){

    for (i in 0 until N-1){
        if(num[i] == num[i+1]) p[i][i+1] = true
    }

    for (i in N-3 downTo 0){
        for (j in i+2 until N){
            if(num[i] == num[j] && p[i+1][j-1]){
                p[i][j] = true
            }
        }
    }

    for (i in 1..M){
        val (a, b) = br.readLine().split(" ").map { it.toInt()-1 }
        write((if(p[a][b]) 1 else 0).toString() + "\n")
    }

    flush()
}

// 시간초과
/**
 * val N = readLine()!!.toInt()
 * val num = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
 * val M = readLine()!!.toInt()
 * val q = Array(M) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }
 *
 * fun main() {
 *      for (i in 0 until M){
 *         val s = num.copyOfRange(q[i][0]-1, q[i][1]).joinToString(",")
 *         if(s == s.reversed()) println(1)
 *         else println(0)
 *      }
 * }
 */
