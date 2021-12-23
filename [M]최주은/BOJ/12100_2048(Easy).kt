/**
 * https://jellyinghead.tistory.com/53
 * 상하좌우 해보고 5회 지난 뒤 가장 큰 값 찾기
 */

package boj.`12100_2048(Easy)`

import kotlin.math.max

val N = readLine()!!.toInt()
var map = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }
var res = 0

fun main() {
    start(0)
    println(res)
}

fun start(count: Int) {
    if (count == 5) {
        findMax()
        return
    }

    val bakM = copy(map)

    for (i in 0 until 4) {
        move(i)
        start(count + 1)
        map = copy(bakM)
    }
}

fun findMax() {
    for (i in 0 until N) {
        for (j in 0 until N) {
            res = max(res, map[i][j])
        }
    }
}

fun move(dir: Int) {
    when (dir) {
        0 -> {
            var i = 0
            while (i < N) {
                var index = 0
                var block = 0
                var j = 0
                while (j < N) {
                    if (map[j][i] !== 0) {
                        if (block == map[j][i]) {
                            map[index - 1][i] = block * 2
                            block = 0
                            map[j][i] = 0
                        } else {
                            block = map[j][i]
                            map[j][i] = 0
                            map[index][i] = block
                            index++
                        }
                    }
                    j++
                }
                i++
            }
        }
        1 -> {
            var i = 0
            while (i < N) {
                var index: Int = N - 1
                var block = 0
                var j: Int = N - 1
                while (j >= 0) {
                    if (map[j][i] !== 0) {
                        if (block == map[j][i]) {
                            map[index + 1][i] = block * 2
                            block = 0
                            map[j][i] = 0
                        } else {
                            block = map[j][i]
                            map[j][i] = 0
                            map[index][i] = block
                            index--
                        }
                    }
                    j--
                }
                i++
            }
        }
        2 -> {
            var i = 0
            while (i < N) {
                var index = 0
                var block = 0
                var j = 0
                while (j < N) {
                    if (map[i][j] !== 0) {
                        if (block == map[i][j]) {
                            map[i][index - 1] = block * 2
                            block = 0
                            map[i][j] = 0
                        } else {
                            block = map[i][j]
                            map[i][j] = 0
                            map[i][index] = block
                            index++
                        }
                    }
                    j++
                }
                i++
            }
        }
        3 -> {
            var i = 0
            while (i < N) {
                var index: Int = N - 1
                var block = 0
                var j: Int = N - 1
                while (j >= 0) {
                    if (map[i][j] !== 0) {
                        if (block == map[i][j]) {
                            map[i][index + 1] = block * 2
                            block = 0
                            map[i][j] = 0
                        } else {
                            block = map[i][j]
                            map[i][j] = 0
                            map[i][index] = block
                            index--
                        }
                    }
                    j--
                }
                i++
            }
        }
    }
}


fun copy(m:Array<Array<Int>>) : Array<Array<Int>> {
    val arr = Array(N) { Array(N) {0} }
    for (i in 0 until N){
        for (j in 0 until N){
            arr[i][j] = m[i][j]
        }
    }
    return arr
}
