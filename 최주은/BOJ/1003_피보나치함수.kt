package com.ssafy.algorithm

class `1003` {
}

var zero:IntArray = IntArray(41) {0}
var one:IntArray = IntArray(41) {0}

fun main() = with(System.`in`.bufferedReader()) {
    var T:Int = readLine()!!.toInt()

    for (i in 0 until T){
        var num = readLine()!!.toInt()
        zero[0] = 1
        one[1] = 1
        fibonacci(num)
        println("${zero[num]} ${one[num]}")
    }
}

fun fibonacci(num:Int) {
    if (num == 0) return
    if (num == 1) return

    if(zero[num-1]==0)
        fibonacci(num-1)

    zero[num] = zero[num-2] + zero[num-1]
    one[num] = one[num-2] + one[num-1]
}
