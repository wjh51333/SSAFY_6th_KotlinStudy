import java.util.*


lateinit var map: Array<Array<Char>>
lateinit var visited: Array<Array<Int>>
var n: Int = 0; var m: Int = 0
var max: Int = 0

fun main() {
    var input = readLine()!!.split(" ")
    n = input[0].toInt()
    m = input[1].toInt()
    map = Array(n) { Array(m) {'0'} }
    visited = Array(n) {Array(m) {-1} }

    for (i in 0 until n) {
        input = readLine()!!.chunked(1)
        for (j in input.indices)
            map[i][j] = input[j][0]
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 'L') {
                visited = Array(n) {Array(m) {-1} }
                bfs(i,j)
                compareMax()
            }
        }
    }
    println(max)
}

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun bfs(x: Int, y: Int) {
    var queue: Queue<Pair<Int, Int>> = LinkedList()

    visited[x][y] = 0
    queue.add(Pair(x, y))

    while (!queue.isEmpty()) {
        val point = queue.remove()

        for (i in dx.indices) {
            val nx = point.first + dx[i]
            val ny = point.second + dy[i]

            if (check(nx, ny)) {
                visited[nx][ny] = visited[point.first][point.second] + 1
                queue.add(Pair(nx, ny))
            }
        }
    }
}

fun check(x: Int, y: Int): Boolean {
    if (x < 0 || x >= n)        return false
    if (y < 0 || y >= m)        return false
    if (visited[x][y] != -1)    return false
    if (map[x][y] == 'L')       return true
    return false
}

fun compareMax() {
    var pair: Pair<Int, Int> = Pair(0, 0)

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j] > visited[pair.first][pair.second]) {
                pair = Pair(i, j)
            }
        }
    }

    if (visited[pair.first][pair.second] > max)
        max = visited[pair.first][pair.second]
}
