package boj.`12865_평범한베낭`

import java.lang.Integer.max

var N = 0
var K = 0
lateinit var items:Array<Pair<Int, Int>>
lateinit var backpack:Array<Array<Int>>

fun main() {
    init()

    for (i in 1 until backpack.size){
        for (w in 1 until backpack[i].size){
            if(w < items[i-1].first) backpack[i][w] = backpack[i-1][w]
            else {
                backpack[i][w] = max(backpack[i - 1][w], items[i-1].second + backpack[i-1][w-items[i-1].first])
            }
        }
    }

    print(backpack[N][K])
}

fun init(){
    val input = readLine()!!.split(" ").map { it.toInt() }
    N = input[0]
    K = input[1]

    items = Array(N) {
        val values = readLine()!!.split(" ").map { it.toInt() }
        Pair(values[0], values[1])
    }

    backpack = Array(N+1){ Array(K+1){0} }
}
