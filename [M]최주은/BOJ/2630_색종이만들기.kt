package boj.`2630_색종이만들기`

import java.awt.Point

// 입력
val N:Int = readLine()!!.toInt()
val map:Array<Array<Int>> = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }

var white = 0
var blue = 0

fun main() {
    divide(Point(0, 0), Point(N, N), N)
    println(white)
    print(blue)
}

fun divide(start:Point, end:Point, n:Int){
    var color:Int = map[start.y][start.x]
    var diff = n/2

    for (i in start.y until end.y){
        for (j in start.x until end.x){
            if(map[i][j] == color) continue
            divide(start, Point(end.x-diff, end.y - diff), diff)
            divide(Point(end.x - diff, start.y), Point(end.x, end.y - diff), diff)
            divide(Point(start.x, end.y - diff), Point(end.x - diff, end.y), diff)
            divide(Point(end.x - diff, end.y - diff), end, diff)
            return
        }
    }

    if(color == 0) white++
    else blue++
}
