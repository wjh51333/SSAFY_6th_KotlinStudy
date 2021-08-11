package com.ssafy.algorithm

import java.util.*

class `1012` {
}

lateinit var map:Array<IntArray>
var M:Int = 0 // 가로
var N:Int = 0 // 세로

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()){
    var T:Int = Integer.parseInt(readLine())
    var TC:Int = 0

    while (TC++ < T) {
        var res = 0

        var st = StringTokenizer(readLine(), " ")
        M = Integer.parseInt(st.nextToken())
        N = Integer.parseInt(st.nextToken())
        val K = Integer.parseInt(st.nextToken())

        map = Array<IntArray>(N) { IntArray(M) }

        for (i in 0 until K) {
            st = StringTokenizer(readLine(), " ")
            val x = Integer.parseInt(st.nextToken())
            val y = Integer.parseInt(st.nextToken())
            map[y][x] = 1
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (map[i][j] == 1) {
                    DFS(i, j)
                    res++
                }
            }
        }

        println(res)
    }
}

fun DFS(y:Int, x:Int){
    // 방문 시 표시
    map[y][x] = 0

    for (i in 0 until 4){
        var xx = x + dx[i]
        var yy = y + dy[i]

        if(checkWall(yy, xx))
            continue

        if (map[yy][xx] == 1)
            DFS(yy,xx)
    }
}

fun checkWall(y:Int, x:Int) : Boolean{
    if(y in 0 until N && x in 0 until M)
        return false
    return true
}

