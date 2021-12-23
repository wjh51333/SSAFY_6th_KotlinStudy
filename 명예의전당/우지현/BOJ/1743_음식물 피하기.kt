private var N = 0
private var M = 0
private var map = arrayOf<IntArray>()
private var visited = arrayOf<BooleanArray>()

private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    N = n
    M = m

    map = Array(N + 1) { IntArray(M + 1) }
    visited = Array(N + 1) { BooleanArray(M + 1) }
    for (i in 1..k) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        map[x][y] = 1
    }

    var answer = 0
    for (i in 1..N) {
        for (j in 1..M) {
            if (map[i][j] == 1 && !visited[i][j]) {
                answer = maxOf(answer, dfs(i, j))
            }
        }
    }
    println(answer)
}

private fun dfs(x : Int, y : Int) : Int {
    visited[x][y] = true

    var ret = 1
    for (i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx !in 1..N || ny !in 1..M) continue
        if (visited[nx][ny] || map[nx][ny] != 1) continue

        ret += dfs(nx, ny)
    }
    return ret
}