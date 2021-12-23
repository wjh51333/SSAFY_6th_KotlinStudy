import java.util.*

private var map = arrayOf<IntArray>()
private var n = 0
private var m = 0

fun main() = with(System.`in`.bufferedReader()) {
    val (c, r) = readLine().split(" ").map { it.toInt() }
    n = r
    m = c

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val tomato = mutableListOf<Pair<Int, Int>>()
    map.forEachIndexed { i, ints ->
        ints.forEachIndexed { j, it ->
            if (it == 1) tomato.add(Pair(i, j))
        }
    }

    if (isRipe()) println(0)
    else println(bfs(tomato))
}

private fun bfs(tomato : MutableList<Pair<Int, Int>>) : Int {
    val q : Queue<Pair<Int, Int>> = LinkedList()
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)

    q.addAll(tomato)

    var time = 0
    while (!q.isEmpty()) {
        val size = q.size
        time ++

        for (s in 1..size) {
            val (x, y) = q.poll()

            for (i in 0 until 4) {
                val nx = x + dx[i]
                val ny = y + dy[i]

                if (nx !in 0 until n || ny !in 0 until m || map[nx][ny] != 0) continue

                map[nx][ny] = map[x][y] + 1
                q.add(Pair(nx, ny))
            }
        }
    }

    if (isRipe()) return time - 1
    return -1
}

private fun isRipe() : Boolean {
    map.forEach {
        it.forEach {
            if (it == 0) return false
        }
    }
    return true
}