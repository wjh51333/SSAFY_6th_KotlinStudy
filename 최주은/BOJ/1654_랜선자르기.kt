package boj.`1654_랜선자르기`

import java.lang.Integer.max
import kotlin.math.max

var K = 0
var N = 0
var arr = ArrayList<Int>()
fun main() {
    val (k, n) = readLine()!!.split(" ").map { it.toInt() }
    K = k
    N = n

    for (i in 0 until K){
        arr.add(readLine()!!.toInt())
    }

    arr.sort()

    var first = 1L
    var last = arr[K-1].toLong()
    var mid: Long
    var max = 1L

    while (first <= last){
        mid = (first+last)/2L
        var cnt = 0L
        arr.forEach { cnt += (it/mid) }
        if (cnt >= N) {
            first = mid+1
            max = max(max, mid)
        }else last = mid-1
    }

    print(max)
}
