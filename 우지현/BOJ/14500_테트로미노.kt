private var n = 0
private var m = 0
private lateinit var map : Array<IntArray>
private lateinit var visited : Array<BooleanArray>

private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(m) }

    var answer = 0
    for (i in map.indices) {
        for (j in map[i].indices) {
            answer = maxOf(answer, dfs(i, j, 0, 0))

            // ㅓ ㅏ 모양
            if (i - 1 >= 0 && i + 1 < n) {
                var tmp = map[i - 1][j] + map[i][j] + map[i + 1][j]

                if (j - 1 >= 0) // ㅓ
                    answer = maxOf(answer, tmp + map[i][j - 1])

                if (j + 1 < m) // ㅏ
                    answer = maxOf(answer, tmp + map[i][j + 1])
            }

            // ㅗ ㅜ 모양
            if (j - 1 >= 0 && j + 1 < m) {
                var tmp = map[i][j - 1] + map[i][j] + map[i][j + 1]

                if (i - 1 >= 0) // ㅗ
                    answer = maxOf(answer, tmp + map[i - 1][j])

                if (i + 1 < n) // ㅜ
                    answer = maxOf(answer, tmp + map[i + 1][j])
            }
        }
    }
    println(answer)
}

private val isWall = { x : Int, y : Int ->
    x < 0 || x >= n || y < 0 || y >= m
}

// dfs로 분홍색 테트로미노 외의 모든 테트로미노를 구할 수 있음
private fun dfs(x : Int, y : Int, cnt : Int, sum : Int) : Int {
    if (cnt == 4) return sum

    visited[x][y] = true

    var ret = 0
    for (i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (!isWall(nx, ny) && !visited[nx][ny]) {
            ret = maxOf(ret, dfs(nx, ny, cnt + 1, sum + map[nx][ny]))
            visited[nx][ny] = false
        }
    }
    visited[x][y] = false
    return ret
}