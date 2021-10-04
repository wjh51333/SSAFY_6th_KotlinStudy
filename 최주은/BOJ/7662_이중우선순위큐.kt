package boj.boj.`7662_이중우선순위큐`

import java.util.*

val T = readLine()!!.toInt()
var tc = 0

class MPair<T, U> : Comparable<MPair<Long, Int>>{
    var values:Long
    var idx:Int

    constructor(values:Long, idx:Int){
        this.values = values
        this.idx = idx
    }

    override fun compareTo(other: MPair<Long, Int>): Int =
        when {
            this.values > other.values -> 1
            this.values < other.values -> -1
            else -> 0
        }
}

fun main() {
    while(tc++ < T){
        val minQ:PriorityQueue<MPair<Int, Int>> = PriorityQueue()
        val maxQ:PriorityQueue<MPair<Int, Int>> = PriorityQueue(Collections.reverseOrder())
        var cnt = 0
        val k = readLine()!!.toInt()
        var visited:Array<Boolean> = Array(k) { false }

        for(i in 0 until k){
            val input = readLine()!!.split(" ").toTypedArray()

            if(input[0] == "I"){
                minQ.add(MPair(input[1].toLong(), i))
                maxQ.add(MPair(input[1].toLong(), i))
                cnt++
                continue
            }

            if(input[0] == "D"){
                if(cnt == 0) continue

                if(input[1].toInt() == 1) {
                    while(!maxQ.isEmpty()){
                        if(!visited[maxQ.peek().idx]) break
                        maxQ.poll()
                    }
                    if(!maxQ.isEmpty()) {
                        visited[maxQ.peek().idx] = true
                        maxQ.poll()
                        cnt--
                    }
                }
                else {
                    while (!minQ.isEmpty()) {
                        if (!visited[minQ.peek().idx]) break
                        minQ.poll()
                    }
                    if (!minQ.isEmpty()) {
                        visited[minQ.peek().idx] = true
                        minQ.poll()
                        cnt--
                    }
                }
            }

            if(cnt == 0) {
                minQ.clear()
                maxQ.clear()
            }
        }

        if (cnt == 0) {
            println("EMPTY")
            continue
        }

        while(!maxQ.isEmpty()){
            if(!visited[maxQ.peek().idx]) break;
            maxQ.poll();
        }

        while(!minQ.isEmpty()){
            if(!visited[minQ.peek().idx]) break;
            minQ.poll();
        }

        println(maxQ.poll().values.toString() + " " + minQ.poll().values.toString())
    }
}
