import java.util.*

var map = arrayOf<IntArray>()

fun main() = with (System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    map = Array(n) {
        readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    println(bfs(n, m))
}

private fun bfs(n : Int, m : Int) : Int {
    val dp = Array<IntArray>(n) { i -> IntArray(m, { 0 })}
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        when {
            map[a.first][a.second] < map[b.first][b.second] -> 1
            map[a.first][a.second] > map[b.first][b.second] -> -1
            else -> 0
        }
    }

    pq.add(Pair(0, 0))
    dp[0][0] = 1

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        val x = now.first
        val y = now.second

        for (k in 0 until 4) {
            val nx = x + dx[k]
            val ny = y + dy[k]

            if (nx in 0 until n && ny in 0 until m && map[nx][ny] < map[x][y]) {
                if (dp[nx][ny] == 0)
                    pq.add(Pair(nx, ny))
                dp[nx][ny] += dp[x][y]
            }
        }
    }
    return dp[n - 1][m - 1]
}