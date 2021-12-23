package boj.`1747_소수&팰린드롬`

import kotlin.math.sqrt

var N = readLine()!!.toInt()

fun main() {

    N = if(N < 2) 2 else N

    while(true){
        if(chk(N) && chk2(N)) break
        N++
    }
    print(N)
}

fun chk(num : Int) : Boolean{
    val end = sqrt(num.toDouble()).toInt()
    for (i in 2..end){
        if(num%i == 0) return false
    }
    return true
}

fun chk2(num : Int) : Boolean{
    val reverse = num.toString().reversed()
    if(num.toString() == reverse) return true
    return false
}
