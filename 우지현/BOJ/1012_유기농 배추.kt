private var map = arrayOf<IntArray>()
private var visited = arrayOf<BooleanArray>()
private var n = 0
private var m = 0

private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val tc = readLine().toInt()
    for (t in 1..tc) {
        val input = readLine().split(" ").map { it.toInt() }
        n = input[1]
        m = input[0]

        map = Array(n) { IntArray(m) }
        visited = Array(n) { BooleanArray(m) }

        for (i in 0 until input[2]) {
            val (y, x) = readLine().split(" ").map { it.toInt() }
            map[x][y] = 1
        }

        var answer = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j)
                    answer++
                }
            }
        }
        println(answer)
    }
}

private fun dfs(x : Int, y : Int) {
    visited[x][y] = true
    for (i in 0 until 4) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 0 until n || ny !in 0 until m) continue
        if (visited[nx][ny] || map[nx][ny] != 1) continue

        dfs(nx, ny)
    }
}