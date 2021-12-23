import java.util.*

lateinit var board: Array<Array<Int>>
lateinit var check: Array<Array<Boolean>>
var M: Int = 0
var N: Int = 0
var cnt: Int = 0
var max: Int = 0
val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)
var flag = false
var q: Queue<IntArray> = LinkedList()
fun main() = with(Scanner(System.`in`)) {
    M = nextInt()
    N = nextInt()
    check = Array<Array<Boolean>>(N) { Array<Boolean>(M) { false } }
    board = Array<Array<Int>>(N) { Array<Int>(M) { 0 } }

    for (i in board.indices) for (j in board[0].indices) board[i][j] = nextInt()
    bfs()
    print(if (flag) -1 else max - 1)
}

fun bfs() {
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 1) {
                q.add(intArrayOf(i, j))
                check[i][j] = true
            }
        }
    }
    while (q.isNotEmpty()) {
        val temp = q.poll()
        for (i in dx.indices) {
            val newx = temp[0] + dx[i]
            val newy = temp[1] + dy[i]

            if (isNotWall(newx, newy) && board[newx][newy] == 0 && !check[newx][newy]) {
                q.add(intArrayOf(newx, newy))
                check[newx][newy] = true
                board[newx][newy] = board[temp[0]][temp[1]] + 1
            }
        }
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            if (!flag && board[i][j] > max) {
                max = board[i][j]
            }
            if (board[i][j] == 0) flag = true
        }
    }
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until M