package boj.`1715_카드정렬하기`

import java.util.*

val N = readLine()!!.toInt()
val cards = PriorityQueue<Int>()
var result = 0

fun main() {
    for (i in 1..N){
        cards.offer(readLine()!!.toInt())
    }

    while (cards.size != 1){
        val t = cards.poll() + cards.poll()
        result += t

        cards.add(t)
    }

    print(result)
}
