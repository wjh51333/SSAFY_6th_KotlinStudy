private var n = 0
private var m = 0
private lateinit var map : Array<IntArray>
private lateinit var visited : Array<IntArray>
private var shape = mutableMapOf<Int, Int>()
private var cnt = 0
private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { IntArray(m) }

    // 각 모양별 크기 구하기
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 1 && visited[i][j] == 0) {
                cnt++
                dfs(i, j)
            }
        }
    }

    var answer = 0
    for (x in map.indices) {
        for (y in map[x].indices) {
            if (map[x][y] == 0) { // 변경 가능
                val list = mutableListOf<Int>() // 현재 위치와 연결 가능한 모양들

                for (k in dx.indices) {
                   val nx = x + dx[k]
                   val ny = y + dy[k]
                   if (isNotWall(nx, ny) && map[nx][ny] == 1) {
                       list.add(visited[nx][ny])
                   }
                }

                // 연결 가능한 모양이 있다면
                if (list.isNotEmpty()) {
                    var sum = 1 // 현재 위치 포함
                    // 전체 모양의 크기 구하기
                    list.distinct().forEach { sum += shape[it]!! }
                    // 최대 크기 갱신
                    answer = maxOf(answer, sum)
                }
            }
        }
    }
    println(answer)
}

private fun isNotWall(x : Int, y : Int) = x >= 0 && x < n && y >= 0 && y < m

private fun dfs(x : Int, y : Int) {
    visited[x][y] = cnt
    shape[cnt] = if (shape.containsKey(cnt)) shape[cnt]!! + 1 else 1

    for (i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (isNotWall(nx, ny) && map[nx][ny] == 1 && visited[nx][ny] == 0) {
            dfs(nx, ny)
        }
    }
}