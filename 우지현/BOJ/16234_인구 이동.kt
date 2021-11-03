import java.util.*
import kotlin.math.abs

private var N = 0
private var L = 0
private var R = 0
private var map = arrayOf<IntArray>()
private var visited = arrayOf<BooleanArray>()

private val dx = arrayOf(-1, 1, 0, 0)
private val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    N = input[0]
    L = input[1]
    R = input[2]
    
    map = Array(N) { readLine().split(" ").map { it.toInt() }.toIntArray() }

    var answer = 0
    while (true) {
        visited = Array(N) { BooleanArray(N) }

        var done = true // 더 이상 인구 이동이 발생하지 않는지 확인
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (!visited[i][j] && bfs(i, j)) {
                    if (done) done = false
                }
            }
        }

        if (done) break
        answer++
    }
    println(answer)
}

private fun bfs(stx : Int, sty : Int) : Boolean {
    val q : Queue<Pair<Int, Int>> = LinkedList()
    val union = mutableListOf<Pair<Int, Int>>()

    q.add(Pair(stx, sty))
    union.add(Pair(stx, sty))
    visited[stx][sty] = true
    
    var sum = map[stx][sty]

    while (q.isNotEmpty()) {
        val (x, y) = q.poll()
        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            
            if (nx !in 0 until N || ny !in 0 until N || visited[nx][ny]) continue

            val diff = abs(map[x][y] - map[nx][ny])
            if (diff >= L && diff <= R) { // 인구 차이가 L 이상 R 이하일 때 국경 열림
                visited[nx][ny] = true
                q.add(Pair(nx, ny))
                union.add(Pair(nx, ny))
                sum += map[nx][ny]
            }
        }
    }

    if (union.size == 1) // 인구 이동 발생 X
        return false
    
    // 인구 이동
    val pop = sum / union.size
    union.forEach { map[it.first][it.second] = pop }
    return true
}

