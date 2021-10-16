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
private var group = mutableListOf<Pair<Int, Int>>()

fun main() = with(System.`in`.bufferedReader()) {
    var input = readLine().split(" ").map { it.toInt() }
    n = input[0]; m = input[1]
    shark = Pair((n + 1) / 2, (n + 1) / 2)

    map = Array(n + 2) { IntArray(n + 2) }
    for (i in 1..n) {
        input = readLine().split(" ").map { it.toInt() }
        for (j in 1..n) {
            map[i][j] = input[j - 1]
        }
    }
    getPoints()

    for (i in 0 until m) {
        val (d, s) = readLine().split(" ")
            .mapIndexed { index, s -> if (index == 0) s.toInt() - 1 else s.toInt() }

        // 블리자드 마법 시전 -> 구슬 파괴
        blizzard(d, s)

        // 구슬 이동
//        move(1)

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
    var ny= shark.second + dy2[d++]
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
    var y = shark.second + dy[d]

    for (i in 0 until s) {
        if (isWall(x, y))
            break

        map[x][y] = 0
        x += dx[d]
        y += dy[d]
    }
}

private fun blowup() {
    val st = Stack<Pair<Int, MutableList<Pair<Int, Int>>>>()
    val zero = ArrayDeque<Pair<Int, Int>>()
    st.add(map[points[0].first][points[0].second] to mutableListOf(points[0]))

    var idx = 1
    while (idx < points.size) {
        var (x, y) = points[idx]
        when (map[x][y]) {
            st.peek().first -> { // 연속하는 구슬은 추가
                if (zero.isNotEmpty()) {
                    val z = zero.removeFirst()
                    map[z.first][z.second] = map[x][y]
                    map[x][y] = 0
                    zero.add(x to y)
                    x = z.first
                    y = z.second
                }
                st.peek().second.add(x to y)
                idx++
            }
            else -> {
                if (st.peek().second.size >= 4) { // 다른 구슬이면 폭발
                    beads[st.peek().first] += st.peek().second.size
                    st.pop().second.forEach {
                        zero.addFirst(it)
                        map[it.first][it.second] = 0
                    }
                }

                if (map[x][y] == 0) {
                    zero.add(x to y)
                    idx++
                }
            }
        }
    }

    group.clear()
    while (st.isNotEmpty()) {
        val (num, list) = st.pop()
        group.add(list.size to num)
    }
    group.reversed()
}

private fun change() {
    var idx = 0
    group.flatMap { it.toList() }.forEach {
        val (x, y) = points[idx++]
        map[x][y] = it
    }
}