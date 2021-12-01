// https://hongjw1938.tistory.com/182
package boj.`2109_순회강연`

import java.util.*

val N = readLine()!!.toInt()
val queue = PriorityQueue<Point>()
var days = Array<Boolean>(10001) { false }
class Point(val p:Int, val d:Int) : Comparable<Point>{
    override fun compareTo(other:Point):Int{
        return other.p - this.p
    }
}

fun main() {
    for (i in 0 until N){
        val input = readLine()!!.split(" ").map { it.toInt() }
        queue.add(Point(input[0], input[1]))
    }

    var result = 0
    while (queue.isNotEmpty()){
        val point = queue.poll()
        for (i in point.d downTo 1){
            if (days[i]) continue
            days[i] = true
            result += point.p
            break
        }
    }

    print(result)
}

//val N = readLine()!!.toInt()
//val map = mutableMapOf<Int,Int>()
//
//fun main() {
//    for (i in 0 until N){
//        val input = readLine()!!.split(" ").map { it.toInt() }
//        if(map.contains(input[1])){
//            if(map[input[1]]!! < input[0]) map[input[1]] = input[0]
//        }else map[input[1]] = input[0]
//    }
//
//    var result = 0
//    map.forEach {
//        result += it.value
//    }
//
//    print(result)
//}
