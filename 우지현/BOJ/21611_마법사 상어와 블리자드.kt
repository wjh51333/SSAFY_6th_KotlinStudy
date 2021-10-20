import java.util.*
import kotlin.collections.ArrayDeque

private var n = 0
private var m = 0
private lateinit var shark : Pair<Int, Int>
private lateinit var map : Array<IntArray>

private var dx = arrayOf(-1, 1, 0, 0)
private var dy = arrayOf(0, 0, -1, 1)

private var dx2 = arrayOf(0, 1, 0, -1)
private var dy2 = arrayOf(-1, 0, 1, 0)
private lateinit var points : MutableList<Pair<Int, Int>>

private var beads = arrayOf(0, 0, 0, 0)
private var group = mutableListOf<Pair<Int, Int>>() // first가 구슬 개수 second가 구슬 번호
private var size = 0

fun main() = with(System.`in`.bufferedReader()) {
    var input = readLine().split(" ").map { it.toInt() }
    n = input[0]; m = input[1]
    shark = Pair((n + 1) / 2, (n + 1) / 2)

    map = Array(n + 2) { IntArray(n + 2) }
    for (i in 1..n) {
        input = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            map[i][j] = input[j - 1]
            if (map[i][j] != 0) size++
        }
    }
    getPoints()

    for (i in 0 until m) {
        val (d, s) = readLine().split(" ")
            .mapIndexed { index, s -> if (index == 0) s.toInt() - 1 else s.toInt() }

        // 블리자드 마법 시전 -> 구슬 파괴
        blizzard(d, s)

        // 구슬 폭발
        blowup()

        // 구슬 변화
        change()
    }
    println("${ beads[1] + 2 * beads[2] + 3 * beads[3]}")
}

private fun getPoints()
{
    var d = 0
    var cnt = 1
    var size = 2
    var (x, y) = shark
    var nx = shark.first + dx2[d]
    var ny= shark.first + dy2[d++]
    points = mutableListOf()

    while (!isWall(nx, ny) && size <= n) {
        x = nx
        y = ny
        points.add(Pair(x, y))

        // 다음 구슬 위치 찾기
        if (cnt == size) {
            if (d == 0 || d == 1)
                size++

            d = (d + 1) % 4
            cnt = if (d == 0) 0 else 1
        }
        nx = x + dx2[d]
        ny = y + dy2[d]
        cnt++
    }
}

private val isWall = { x : Int, y : Int ->
    x !in 1..n || y !in 1..n
}

private fun blizzard(d : Int, s : Int) {
    var x = shark.first + dx[d]
    var y = shark.first + dy[d]

    for (i in 0 until s) {
        if (isWall(x, y) || map[x][y] == 0)
            break

        map[x][y] = 0
        x += dx[d]
        y += dy[d]
    }
}

private fun blowup() {
    val list = mutableListOf<Int>()
    for (idx in 0 until size) {
        val (x, y) = points[idx]
        if (map[x][y] != 0)
            list.add(map[x][y])
    }

    val st = Stack<Pair<Int, Int>>()

    var idx = 0
    while (idx < list.size) {
        if (st.isEmpty() || st.peek().first != list[idx]) {
            if (st.isNotEmpty() && st.peek().second >= 4) {
                beads[st.peek().first] += st.peek().second
                st.pop()
            }

            if (st.isEmpty() || st.peek().first != list[idx]) {
                st.add(list[idx] to 1)
                idx++
            }
        } else {
            val now = st.pop()
            st.add(now.first to now.second + 1)
            idx++
        }
    }

    if (st.isNotEmpty()) {
        if (st.peek().second >= 4) {
            beads[st.peek().first] += st.peek().second
            st.pop()
        }

        while (st.isNotEmpty()) {
            val tmp = st.pop()
            group.add(tmp.second to tmp.first)
        }
        group.reverse()
    }
}

private fun change() {
    val list = group.flatMap { it.toList() }
    var idx = 0

    map.forEach { it.fill(0) }
    size = if (list.size > points.size) points.size else list.size

    if (list.isNotEmpty()) {
        for (i in points.indices) {
            val (x, y) = points[i]
            map[x][y] = list[idx++]
            if (idx == list.size)
                break
        }
    }
    group.clear()
}