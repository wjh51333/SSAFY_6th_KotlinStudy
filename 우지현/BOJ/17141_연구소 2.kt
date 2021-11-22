import java.util.*

private var n = 0
private var m = 0
private lateinit var map : Array<IntArray>
private lateinit var visited : Array<BooleanArray>
private val virus = mutableListOf<Pair<Int, Int>>()
private val selected = mutableListOf<Pair<Int, Int>>()

fun main() = with(System.`in`.bufferedReader()) {
    val info = readLine().split(" ").map { it.toInt() }
    n = info[0]
    m = info[1]

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 2) {
                virus.add(i to j)
            }
        }
    }
    val result = go(0)
    println(if (result == Int.MAX_VALUE) -1 else result)
}

private fun go(idx : Int) : Int{
    if (selected.size == m) {
        return bfs()
    }

    var min = Int.MAX_VALUE
    for (i in idx until virus.size) {
        selected.add(virus[i])
        min = minOf(min, go(i + 1))
        selected.removeLast()
    }
    return min
}

private val isNotWall = { x : Int, y : Int -> x in 0 until n && y in 0 until n }

private fun bfs() : Int {
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val q : Queue<Pair<Int, Int>> = LinkedList()
    var time = 0

    for (i in 0 until n) {
        visited[i].fill(false)
    }

    q.addAll(selected)
    selected.forEach { visited[it.first][it.second] = true }

    while (q.isNotEmpty()) {
        val size = q.size
        for (s in 0 until size) {
            val (x, y) = q.poll()
            for (i in dx.indices) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (isNotWall(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true
                    q.add(nx to ny)
                }
            }
        }
        if (q.isNotEmpty()) time++
    }
    return if (checkEmptyCells()) Int.MAX_VALUE else time
}

private fun checkEmptyCells() : Boolean {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && map[i][j] != 1) {
                return true
            }
        }
    }
    return false
}