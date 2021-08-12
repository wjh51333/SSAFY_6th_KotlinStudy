import java.util.*


lateinit var map: Array<Array<Int>>
lateinit var visited: Array<Array<Boolean>>
var n: Int = 0; var m: Int = 0

fun main() {
    val t = readLine()!!.toInt()

    for (tc in 1..t) {
        var input = readLine()!!.split(" ")
        m = input[0].toInt()
        n = input[1].toInt()
        val k = input[2].toInt()

        map = Array(m) {Array(n) {0} }
        visited = Array(m) {Array(n) {false} }
        for (i in 1..k) {
            input = readLine()!!.split(" ")
            map[input[0].toInt()][input[1].toInt()] = 1
        }

        var ans = 0;
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (map[i][j] == 1) {
                    // dfs로 풀기
                    ans += dfs(i, j)
                    // bfs로 풀기
//                     if (!visited[i][j])
//                         ans += bfs(i, j)
                }
            }
        }
        println(ans)
    }
}

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun dfs(x: Int, y: Int): Int {
    if(visited[x][y])
        return 0

    visited[x][y] = true
    for (i in dx.indices) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (check(nx, ny))
            dfs(nx, ny)
    }
    return 1
}

fun bfs(x: Int, y: Int): Int {
    var queue: Queue<Pair<Int, Int>> = LinkedList();

    visited[x][y] = true
    queue.add(Pair(x, y))

    while (!queue.isEmpty()) {
        val point = queue.remove()

        for (i in dx.indices) {
            val nx = point.first + dx[i]
            val ny = point.second + dy[i]

            if (check(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true
                queue.add(Pair(nx, ny))
            }
        }
    }

    return 1
}

fun check(x: Int, y: Int): Boolean {
    if (x < 0 || x >= m)    return false
    if (y < 0 || y >= n)    return false
    if (map[x][y] == 1)     return true
    return false
}
