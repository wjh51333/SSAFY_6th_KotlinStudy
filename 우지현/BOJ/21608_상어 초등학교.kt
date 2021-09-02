private var n = 0
private var num = intArrayOf()
private var info = arrayOf<List<Int>>()
private var student = arrayOf<IntArray>()
private var empty = arrayOf<IntArray>()
private val dx = arrayOf(-1, 0, 0, 1)
private val dy = arrayOf(0, -1, 1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    num = IntArray(n * n)
    info = Array<List<Int>>(n * n + 1) { listOf<Int>() }
    student = Array(n) { IntArray(n) }
    empty = Array(n) { IntArray(n) }

    for (i in 0 until n * n) {
        val input = readLine().split(" ").map { it.toInt() }
        num[i] = input[0]
        info[num[i]] = input.subList(1, 5)
    }
    init()

    for (i in num.indices) {
        var seat = getMax(num[i])

        student[seat.first][seat.second] = num[i]
        empty[seat.first][seat.second] = -1

        for (i in dx.indices) {
            val nx = seat.first + dx[i]
            val ny = seat.second + dy[i]
            if (!isNotWall(nx, ny) || empty[nx][ny] < 0) continue
            empty[nx][ny]--
        }
    }
    println(satisfied())
}

private fun init() {
    for (i in empty.indices) {
        for (j in empty[i].indices) {
            empty[i][j] = 4;
            if (i == 0 || i == n - 1) empty[i][j]--
            if (j == 0 || j == n - 1) empty[i][j]--
        }
    }
}

private fun getMax(now : Int) : Pair<Int, Int> {
    var max = 0
    var list = mutableListOf<Pair<Int, Int>>()
    for (i in empty.indices) {
        for (j in empty[i].indices) {
            if (student[i][j] != 0) continue
            var likes = 0 // 인접한 칸에 있는 좋아하는 학생 수
            for (k in dx.indices) {
                val ni = i + dx[k]
                val nj = j + dy[k]
                if (!isNotWall(ni, nj)) continue
                if (info[now].contains(student[ni][nj])) likes++
            }
            if (max < likes) { // 최댓값을 갱신하면서 자리가 될 수 있는 후보도 갱신
                list.clear()
                list.add(Pair(i, j))
                max = likes
            } else if (max == likes) { // 최댓값과 같으면 추가
                list.add(Pair(i, j))
            }
        }
    }
    // 인접한 칸에 있는 좋아하는 학생 수가 동일한 자리가 있으면
    // 인접한 칸 중에서 비어있는 칸이 가장 많은 칸에 대해 내림차순으로 정렬
    // sortWith는 stable sort라 3번 조건은 유지됨
    list.sortWith(compareByDescending({ empty[it.first][it.second] }))
    return list[0]
}

private fun isNotWall(x : Int, y : Int) = x in 0 until n && y in 0 until n

private fun satisfied() : Int {
    var sum = 0
    for (i in student.indices) {
        for (j in student[i].indices) {
            var cnt = 0
            for (k in dx.indices) {
                val nx = i + dx[k]
                val ny = j + dy[k]
                if (!isNotWall(nx, ny)) continue
                if (info[student[i][j]].contains(student[nx][ny])) cnt++
            }
            if (cnt > 1) sum += Math.pow(10.toDouble(), (cnt - 1).toDouble()).toInt()
            else sum += cnt
        }
    }
    return sum
}