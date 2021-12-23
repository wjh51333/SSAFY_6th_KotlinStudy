package boj.`17144_미세먼지안녕`

import java.awt.Point
import java.util.*
import kotlin.collections.ArrayList

var R = 0
var C = 0
var T = 0
lateinit var map:Array<Array<Int>>
val dy = arrayOf(-1,0,1,0)
val dx = arrayOf(0,1,0,-1)

val dy2 = arrayOf(1,0,-1,0)
val dx2 = arrayOf(0,1,0,-1)
var cleanerPoint = ArrayList<Point>()

fun main() {
    val (a,b,c) = readLine()!!.split(" ").map { it.toInt() }
    R = a
    C = b
    T = c

    map = Array(R) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }

    for (i in 0 until R){
        if (map[i][0] == -1) cleanerPoint.add(Point(0,i))
    }

    for (i in 0 until T) {
        spreadDust()
//        map.forEach { it.forEach { print("%2d ".format(it)) }
//        println()}
//
//        println()

        airCleaner()
//        map.forEach { it.forEach { print("%2d ".format(it)) }
//            println()}
    }

    var res = 0
    map.forEach { res += it.sum() }
    print(res+2)
}

fun airCleaner() {
    // 위
    var p = cleanerPoint[0]
    var xx = p.x
    var yy = p.y

    for (k in 0 until 4){
        while (true){
            xx += dx[k]
            yy += dy[k]

            if (xx < 0 || xx >= C || yy < 0 || yy > p.y){
                xx -= dx[k]
                yy -= dy[k]
                break
            }

            if(map[yy][xx] == -1){
                xx -= dx[k]
                yy -= dy[k]
                map[yy][xx] = 0
                break
            }

            if (map[yy-dy[k]][xx-dx[k]] == -1) continue
            map[yy-dy[k]][xx-dx[k]] = map[yy][xx]
        }
    }

    // 아래
    p = cleanerPoint[1]
    xx = p.x
    yy = p.y

    for (k in 0 until 4){
        while (true){
            xx += dx2[k]
            yy += dy2[k]

            if (xx < 0 || xx >= C || yy < p.y || yy >= R){
                xx -= dx2[k]
                yy -= dy2[k]
                break
            }

            if(map[yy][xx] == -1){
                xx -= dx[k]
                yy -= dy[k]
                map[yy][xx] = 0
                break
            }

            if (map[yy-dy2[k]][xx-dx2[k]] == -1) continue
            map[yy-dy2[k]][xx-dx2[k]] = map[yy][xx]
        }
    }

}

fun spreadDust() {
    val newMap = Array(R){Array(C){0}}
    newMap[cleanerPoint[0].y][cleanerPoint[0].x] = -1
    newMap[cleanerPoint[1].y][cleanerPoint[1].x] = -1

    for (i in 0 until R){
        for (j in 0 until C){
            if(map[i][j] == 0 || map[i][j] == -1) continue

            val adder = map[i][j]/5
            var count = 0

            for (k in 0 until 4){
                val xx = j + dx[k]
                val yy = i + dy[k]

                if(xx < 0 || xx >= C || yy < 0 || yy >= R || map[yy][xx] == -1) continue

                count++
                newMap[yy][xx] += adder
            }
            newMap[i][j] += map[i][j] - adder*count
        }
    }

    map = newMap
}
