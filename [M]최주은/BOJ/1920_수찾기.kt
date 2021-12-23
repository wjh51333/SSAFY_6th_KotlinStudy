package boj.`1920_수찾기`

import java.util.*

fun main() {
    val N = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }
    Collections.sort(arr)

    val M = readLine()!!.toInt()
    val find = readLine()!!.split(" ").map { it.toInt() }


    for (k in find.indices){
        var first = 0
        var last = N-1
        var trigger = false
        while (first <= last){
            val mid = (first + last) / 2
            if (arr[mid] == find[k]) {
                println(1)
                trigger = true
                break
            }

            if (arr[mid] < find[k]) {
                first = mid+1
            }else last = mid-1
        }

        if (!trigger) println(0)
    }
}
