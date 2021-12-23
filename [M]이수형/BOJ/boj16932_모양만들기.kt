package today2

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

var N = 0
var M = 0
var idx = 1
var cnt = 0
var total = 0
var max = 0
lateinit var board: Array<Array<Int>>
lateinit var check: Array<Array<Boolean>>
lateinit var savecnt: ArrayList<Int>
lateinit var dircheck: ArrayList<Int>
var dx = arrayOf(-1, 1, 0, 0)
var dy = arrayOf(0, 0, -1, 1)
fun main() {

    var st = readLine()!!.split(" ")
    N = st[0].toInt()
    M = st[1].toInt()
    board = Array(N) { st = readLine()!!.split(" ");Array(M) { st[it].toInt() } }
    check = Array(N) { Array(M) { false } }
    savecnt = ArrayList()

    for (i in board.indices) for (j in board[0].indices) if (board[i][j] == 1 && !check[i][j]) bfs(i, j)
    for (i in board.indices) for (j in board[0].indices) if (board[i][j] == 0) findmax(i, j)
    println(max + 1)
}

fun findmax(x: Int, y: Int) {
    dircheck = ArrayList()
    total = 0
    for (i in dx.indices) {
        val newx = x + dx[i]
        val newy = y + dy[i]
        if (isNotWall(newx, newy) && !dircheck.contains(board[newx][newy]) && board[newx][newy] != 0) {
            dircheck.add(board[newx][newy])
            total += savecnt[board[newx][newy] - 1]
        }
    }
    max = max(max, total)
}

fun bfs(x: Int, y: Int) {
    cnt = 1
    var q = LinkedList<IntArray>()
    q.add(intArrayOf(x, y))
    while (q.isNotEmpty()) {
        var temp = q.poll()
        check[temp[0]][temp[1]] = true
        board[temp[0]][temp[1]] = idx
        for (i in dx.indices) {
            val newx = temp[0] + dx[i]
            val newy = temp[1] + dy[i]
            if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 1) {
                board[newx][newy] = idx
                check[newx][newy] = true
                q.add(intArrayOf(newx, newy))
                cnt++
            }
        }
    }
    savecnt.add(cnt)
    idx++
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until M