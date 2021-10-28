import java.util.*

private lateinit var map : Array<IntArray>
private val puri = mutableListOf<Pair<Int, Int>>()
private var dust = mutableSetOf<Pair<Pair<Int, Int>, Int>>()
private val dx = arrayOf(-1, 0, 1, 0)
private val dy = arrayOf(0, 1, 0, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, T) = readLine().split(" ").map { it.toInt() }
    map = Array(n) { readLine().split(" ").mapNotNull { it.toIntOrNull() }.toIntArray() }

    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == -1)
                puri.add(i to j)
            else if (map[i][j] > 0)
                dust.add((i to j) to map[i][j])
        }
    }

    for (t in 0 until T) {
        findDust()
        spread()
        move(puri[0], 0, 1)
        move(puri[1], 2, -1)
    }

    var answer = 0
    map.forEach { list ->
        list.forEach { d ->
            if (d > 0) answer += d
        }
    }
    println(answer)
}

private val isNotWall = { x : Int, y : Int -> x >= 0 && x < map.size && y >= 0 && y < map[0].size }

private fun findDust() {
    dust.clear()
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] > 0)
                dust.add((i to j) to map[i][j])
        }
    }
}

private fun spread() {
    dust.forEach {
        val (pos, num) = it
        val (x, y) = pos

        var cnt = 0
        var ds = num / 5

        for (i in dx.indices) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (isNotWall(nx, ny) && map[nx][ny] != -1) {
                map[nx][ny] += ds
                cnt++
            }
        }

        map[x][y] -= cnt * ds
        if (map[x][y] < 0)
            map[x][y] = 0
    }
}

private val isWall = { start : Pair<Int, Int>, x : Int, y : Int, flag : Int->
    if (flag == 1)
        x < 0 || x > start.first || y < 0 || y >= map[0].size
    else
        x < start.first || x >= map.size || y < 0 || y >= map[0].size
}

private fun move(start : Pair<Int, Int>, sd : Int, offset : Int) {
    var (x, y) = start
    var d = sd
    var (nx, ny) = x + dx[d] to y + dy[d]

    while ((nx to ny) != start) {
        if (!isWall(start, nx, ny, offset)) {
            if (map[x][y] != -1)
                map[x][y] = map[nx][ny]
            map[nx][ny] = 0
            x = nx
            y = ny
        }

        nx = x + dx[d]
        ny = y + dy[d]
        if (isWall(start, nx, ny, offset)) {
            d = (d + offset + 4) % 4
            nx = x + dx[d]
            ny = y + dy[d]
        }
    }
}