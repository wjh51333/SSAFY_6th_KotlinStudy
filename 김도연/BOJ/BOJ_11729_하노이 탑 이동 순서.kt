import kotlin.math.*

var sb = StringBuffer()   // println문을 쓰면 시간초과

fun hanoi(n :Int, from :Char, temp :Char, to :Char) {
    if (n == 1) {
        sb.append("$from $to").append("\n")
        return
    }

    hanoi(n - 1, from, to, temp)
    sb.append("$from $to").append("\n")
    hanoi(n - 1, temp, from, to)
}

fun main() {

    var n = readLine()!!.toInt()
    
    println(((2.0).pow(n) - 1).toInt())   // f(n) = 2(fn-1) + 1  == (일반항) ==> f(n) = 2^n - 1
    hanoi(n, '1', '2', '3')
    println(sb)
}
