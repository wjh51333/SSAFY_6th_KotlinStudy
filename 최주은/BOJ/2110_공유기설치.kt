package boj.`2110_공유기설치`

import java.lang.Long.max
import kotlin.collections.ArrayList

var N = 0
var C = 0
lateinit var house : ArrayList<Long>
var res = 0L

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    N = input[0]
    C = input[1]

    house = ArrayList()

    for (i in 0 until N){
        house.add(readLine()!!.toLong())
    }

    house.sort()

    var first = 0L
    var last = house[house.size-1]

    while (first <= last){
        val mid = (first+last)/2

        if (possible(mid)){
            res = max(res, mid)
            first = mid+1
        }else last = mid-1
    }

    print(res)
}

fun possible(mid: Long):Boolean{
    var trigger = false
    var cnt = 1
    var n = 0

    for (i in 0 until N-1){
        if (house[n] + mid <= house[i+1]){
            cnt++
            n = i + 1
        }
    }

    if(cnt >= C) trigger = true
    return trigger
}
