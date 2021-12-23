import java.util.*

private var map = listOf<String>()
private var visited = arrayOf<BooleanArray>()
private var n = 0
private var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (r, c) = readLine().split(" ").map { it.toInt() }
    n = r
    m = c

    map = List(n) { readLine() }

    var answer = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 'L') {
                visited = Array(n) { BooleanArray(m) }
                answer = maxOf(answer, bfs(Pair(i, j)))
            }
        }
    }
    println(answer)
}

private fun bfs(start : Pair<Int, Int>) : Int {
    val q : Queue<Pair<Pair<Int, Int>, Int>> = LinkedList()
    q.add(Pair(start, 0))
    visited[start.first][start.second] = true

    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    var max = 0
    while (!q.isEmpty()) {
        val now = q.poll()
        val (x, y) = now.first
        val dist = now.second

        if (max < dist) max = dist

        for (i in 0 until 4) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx !in 0 until n || ny !in 0 until m) continue
            if (visited[nx][ny] || map[nx][ny] != 'L') continue

            visited[nx][ny] = true
            q.add(Pair(Pair(nx, ny), dist + 1))
        }
    }
    return max
}