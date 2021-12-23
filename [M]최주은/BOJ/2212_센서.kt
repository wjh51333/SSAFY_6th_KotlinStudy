package boj.`2212_센서`

import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

val N = readLine()!!.toInt()
val K = readLine()!!.toInt()
var line = readLine()!!.split(" ").map { it.toInt() }
var res = Integer.MAX_VALUE

fun main() {
    if(K >= N){
        print(0)
        exitProcess(0)
    }

    Collections.sort(line)

    var diff = ArrayList<Int>()

    for (i in 0 until N-1){
        diff.add(line[i+1] - line[i])
    }

    diff.sortDescending()

    var res = 0
    for (i in K-1 until N-1){
        res += diff[i]
    }

    print(res)
}
