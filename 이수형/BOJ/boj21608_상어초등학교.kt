import java.util.*

lateinit var student: Array<Array<Int>>
lateinit var board: Array<Array<Int>>
var dx = arrayOf(-1, 1, 0, 0)
var dy = arrayOf(0, 0, 1, -1)
var N = 0
fun main() = with(Scanner(System.`in`)) {
    N = nextInt();
    student = Array(N * N) { Array(5) { nextInt() } }
    board = Array(N) { Array(N) { 0 } }
    for (i in student.indices) {
        setseat(emptyconut(friendboard(i)), student[i][0])
    }
    var sum = 0
    for (i in 0 until N) {
        for (j in 0 until N) {
            var k = 0
            while (student[k][0] != board[i][j]) k++
            sum += clac(i, j, student[k])
        }

    }
    println(sum)
}

fun friendboard(num: Int): ArrayList<Array<Int>> {
    var fboard = Array(N) { Array(N) { 0 } }
    var q = ArrayList<Array<Int>>()
    var max = 0
    for (i in board.indices) {
        for (j in board.indices) {
            var cnt = 0;
            if (board[i][j] == 0) {
                for (k in dx.indices) {
                    val newx = i + dx[k]
                    val newy = j + dy[k]
                    if (isNotWall(newx, newy) && student[num].contains(board[newx][newy])) cnt++
                }
            }
            max = max.coerceAtLeast(cnt)
            fboard[i][j] = cnt;
        }
    }
    for (i in fboard.indices) {
        for (j in fboard.indices) {
            if (fboard[i][j] == max) q.add(arrayOf(i, j))
        }
    }
    return q;
}

fun emptyconut(q: ArrayList<Array<Int>>): ArrayList<Array<Int>> {
    var q2 = ArrayList<Array<Int>>()
    var max = 0;
    for (seat in q.indices) {
        var cnt = 0;
        val i = q[seat][0]
        val j = q[seat][1]
        if (board[i][j] == 0) {
            for (k in dx.indices) {
                val newx = i + dx[k]
                val newy = j + dy[k]
                if (isNotWall(newx, newy) && board[newx][newy] == 0) cnt++
            }
        }
        max = max.coerceAtLeast(cnt)
    }
    for (seat in q.size - 1 downTo 0) {
        var cnt = 0;
        val i = q[seat][0]
        val j = q[seat][1]
        if (board[i][j] == 0) {
            for (k in dx.indices) {
                val newx = i + dx[k]
                val newy = j + dy[k]
                if (isNotWall(newx, newy) && board[newx][newy] == 0) cnt++
            }
        }
        if (max == cnt) q2.add(arrayOf(i, j))
    }
    return q2
}

fun setseat(q: ArrayList<Array<Int>>, num: Int) {
    if (q.size != 0)
        q.sortWith(compareBy({ it[0] }, { it[1] }))
    board[q[0][0]][q[0][1]] = num
}

fun clac(i: Int, j: Int, friend: Array<Int>): Int {
    var cnt = 0
    for (k in dx.indices) {
        val newx = i + dx[k]
        val newy = j + dy[k]
        if (isNotWall(newx, newy) && friend.contains(board[newx][newy])) {
            cnt++
        }
    }
    return if (cnt < 2) cnt else Math.pow(10.0, (cnt - 1).toDouble()).toInt()
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until N;