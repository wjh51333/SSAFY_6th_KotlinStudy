package com.ssafy.algorithm

import java.util.*

class 토마토 {
}

data class point(var y: Int, var x: Int)

var queue = LinkedList<point>()
var tomatoCount = 0

val yy:IntArray = intArrayOf(-1, 1, 0, 0)
val xx:IntArray = intArrayOf(0, 0, -1, 1)
lateinit var size:IntArray
lateinit var tomatoMap:Array<IntArray>

fun main()=with(System.`in`.bufferedReader()){
    size = readLine().split(" ").map { it.toInt() }.toIntArray()
    tomatoMap = Array(size[1]) { IntArray(size[0]) }

    // 입력받기
    for (i in tomatoMap.indices){
        var st = readLine().split(" ")
        for (j in tomatoMap[i].indices){
            tomatoMap[i][j] = st[j].toInt()
            if(tomatoMap[i][j] == 0)
                tomatoCount++
        }
    }

    for (i in tomatoMap.indices){
        for (j in tomatoMap[i].indices){
            if(tomatoMap[i][j] == 1){
                queue.add(point(i,j))
            }
        }
    }

    BFS();

    var res = 0
    var tr = false

    for ( i in 0 until size[1] ){
        for ( j in 0 until size[0] ){
            if (tomatoMap[i][j] == 0) {
                res = -1
                tr = true
                break
            }
            res = res.coerceAtLeast(tomatoMap[i][j])
        }

        if(tr)
            break
    }

    if(res != -1)
        print(res-1)
    else
        print(res)
}

fun BFS(){
    while (queue.isNotEmpty()) {
        var temp = queue.poll()

        for (i in yy.indices) {
            var Y = temp.y + yy[i]
            var X = temp.x + xx[i]

            if (isWall(Y, X))
                continue

            if (tomatoMap[Y][X] != 0)
                continue

            queue.add(point(Y, X))
            tomatoMap[Y][X] = tomatoMap[temp.y][temp.x] + 1
        }
    }
}

fun isWall(y:Int, x:Int) : Boolean {
    if (y in 0 until size[1] && x in 0 until size[0])
        return false
    return true
}
