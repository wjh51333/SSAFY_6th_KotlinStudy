package boj.`9372_상근이의여행`

var T = readLine()!!.toInt()

fun main() {
    var tc = 0
    while (tc++ < T) {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        for (i in 0 until m) readLine()!!
        println(n-1)
    }
}
