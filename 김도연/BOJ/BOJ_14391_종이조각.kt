// https://vixxcode.tistory.com/23

import kotlin.math.max

fun main() {
    val input = readLine()!!.split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()

    val arr = Array(n) { readLine()!!.chunked(1).map { it.toInt() }.toIntArray() }
    var max = 0

    for (i in 0 until (1 shl n*m)) {
        var sum = 0
        // 가로 합
        for (r in 0 until n) {
            var rsum = 0
            for (c in 0 until m) {
                val pos = (r * m) + c
                if (i and (1 shl pos) != 0) {
                    sum += rsum
                    rsum = 0
                } else {
                    rsum = rsum*10 + arr[r][c]
                }
            }
            sum += rsum
        }

        // 세로합
        for (c in 0 until m) {
            var csum = 0
            for (r in 0 until n) {
                val pos = (r * m) + c
                if (i and (1 shl pos) != 0) {
                    csum = csum*10 + arr[r][c]
                } else {
                    sum += csum
                    csum = 0
                }
            }
            sum += csum
        }

        max = max(max, sum)
    }

    println(max)
}