import java.util.*


lateinit var boxes: Array<Array<Int>>
var m = 0
var n = 0


fun main() {
    val temp = readLine()!!.split(" ")
    m = temp[0].toInt()
    n = temp[1].toInt()

    boxes = Array(n) { Array(m) {0} }
    for (i in 0 until n) {
        val s = readLine()!!.split(" ")
        for (j in s.indices) {
            boxes[i][j] = s[j].toInt()
        }
    }

    //dfs()
    val ans = bfs()

    var flag = true
    for (i in 0 until n)
        for (j in 0 until m)
            if (boxes[i][j] == 0)
                flag = false

    if (flag)
        println(ans)
    else
        println(-1)
}

fun dfs() {

}

fun bfs(): Int {
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)
    var queue: Queue<IntArray> = LinkedList()

    // 첫 날 익은 토마토 위치 저장 (세로위치, 가로위치, 날짜)
    for (i in 0 until n)
        for (j in 0 until m)
            if (boxes[i][j] == 1)
                queue.add(intArrayOf(i, j, 0))

    var day = 0
    while (!queue.isEmpty()) {
        val point = queue.remove()
        day = point[2]

        for (i in dx.indices) {
            val nx = point[0] + dx[i]
            val ny = point[1] + dy[i]

            if (check(nx, ny)) {
                boxes[nx][ny] = 1
                queue.add(intArrayOf(nx, ny, day+1))
            }
        }
    }

    return day
}

fun check(x: Int, y: Int): Boolean {
    if (x < 0 || x >= n)    return false
    if (y < 0 || y >= m)    return false
    if (boxes[x][y] == 0)   return true
    return false
}
