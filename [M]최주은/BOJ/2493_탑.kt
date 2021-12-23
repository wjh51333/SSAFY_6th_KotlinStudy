package boj.`2493_탑`

import java.util.*

val N = readLine()!!.toInt()
val tops = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
val stack = Stack<Pair<Int,Int>>()

fun main() {
    for (i in tops.indices){
        while (stack.isNotEmpty()) {
            if (stack.peek().first >= tops[i]){
                print("${stack.peek().second+1} ")
                stack.push(Pair(tops[i], i))
                break
            }
            else stack.pop()
        }

        if (stack.empty()){
            print("0 ")
            stack.push(Pair(tops[i], i))
            continue
        }
    }
}
