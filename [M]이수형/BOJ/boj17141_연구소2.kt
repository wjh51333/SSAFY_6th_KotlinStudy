package today3

import java.util.*


var N = 0
var M = 0
var min = 0
var wall = 0
lateinit var board: Array<IntArray>
lateinit var useboard: Array<IntArray>
var viruslist: ArrayList<IntArray>? = null
var dx = intArrayOf(0, 0, 1, -1)
var dy = intArrayOf(1, -1, 0, 0)
lateinit var check: BooleanArray
lateinit var virusx: IntArray
lateinit var virusy: IntArray
fun main() = with(System.`in`.bufferedReader()) {

    var temp = readLine().split(" ".toRegex()).toTypedArray()
    N = temp[0].toInt()
    M = temp[1].toInt()
    viruslist = ArrayList()
    board = Array(N) { IntArray(N) }
    useboard = Array(N) { IntArray(N) }
    virusx = IntArray(M)
    virusy = IntArray(M)
    min = 9999
    wall = 0
    for (i in 0 until N) {
        temp = readLine().split(" ".toRegex()).toTypedArray()
        for (j in 0 until N) {
            val num = temp[j].toInt()
            if (num == 1) {
                // 벽 처리
                board[i][j] = -1
                wall++
            } else if (num == 2) {
                // 바이러스 위치 리스트
                viruslist!!.add(intArrayOf(i, j))
                board[i][j] = 0
            } else {
                board[i][j] = num
            }
        }
    }
    check = BooleanArray(viruslist!!.size)
    makeboard()
    findpoint(0, 0)
    if (min != 9999) {
        println(min - 1)
    } else {
        println(-1)
    }
}

fun bfs(virusx: IntArray, virusy: IntArray) {
    var cnt = wall
    var cal = 0
    val q: Queue<IntArray> = LinkedList()
    for (i in 0 until M) {
        q.add(intArrayOf(virusx[i], virusy[i]))
        useboard[virusx[i]][virusy[i]] += 1
        cal = Integer.max(cal, useboard[virusx[i]][virusy[i]])
        cnt++
    }
    while (!q.isEmpty()) {
        if (cal > min) break
        val len = q.size
        for (k in 0 until len) {
            val temp = q.poll()
            for (i in dx.indices) {
                val newx = temp[0] + dx[i]
                val newy = temp[1] + dy[i]
                if (isNotWall(newx, newy) && useboard[newx][newy] == 0) {
                    useboard[newx][newy] = useboard[temp[0]][temp[1]] + 1
                    q.add(intArrayOf(newx, newy))
                    cnt++
                    cal = Integer.max(cal, useboard[newx][newy])
                }
            }
        }
    }
    if (cnt == N * N) {
        min = Integer.min(min, cal)
    }
}

fun findpoint(depth: Int, start: Int) {
    if (depth == M) {
        bfs(virusx, virusy)
        makeboard()
        return
    }
    for (i in start until viruslist!!.size) {
        if (!check[i]) {
            check[i] = true
            virusx[depth] = viruslist!![i][0]
            virusy[depth] = viruslist!![i][1]
            findpoint(depth + 1, i + 1)
            check[i] = false
        }
    }
}

fun isNotWall(x: Int, y: Int): Boolean {
    return x in 0 until N && y in 0 until N
}


fun makeboard() {
    for (i in 0 until N) {
        System.arraycopy(board[i], 0, useboard[i], 0, N)
    }
}

