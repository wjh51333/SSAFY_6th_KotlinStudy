import java.util.*
import kotlin.math.max

lateinit var board: Array<Array<Char>>
lateinit var check: Array<Array<Boolean>>
var dx = arrayOf(-1, 1, 0, 0)
var dy = arrayOf(0, 0, 1, -1)
var N = 0;
var M = 0;
var cnt = 0
var max = 0
fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt()
    board = Array<Array<Char>>(N) { Array<Char>(M) { ' ' } }
    check = Array<Array<Boolean>>(N) { Array<Boolean>(M) { false } }

    for (i in board.indices) {
        val temp = next()
        for (j in board[0].indices) board[i][j] = temp[j]
    }
    for (i in board.indices) for (j in board[0].indices) {
        if (board[i][j] == 'L') {
            cnt = 0
            init()
            bfs(i, j)
            max = max(max, cnt)
        }
    }
    print(max)
}

fun bfs(x: Int, y: Int) {
    val q = LinkedList<IntArray>()
    q.add(intArrayOf(x, y))
    check[x][y] = true
    val save = Array<Array<Int>>(N) { Array<Int>(M) { 0 } }

    while (q.isNotEmpty()) {
        val temp = q.poll()
        for (i in dx.indices) {
            val newx = temp[0] + dx[i]
            val newy = temp[1] + dy[i]
            if (isNotWall(newx, newy) && board[newx][newy] == 'L' && !check[newx][newy]) {
                q.add(intArrayOf(newx, newy))
                check[newx][newy] = true
                save[newx][newy] += save[temp[0]][temp[1]] + 1
            }
        }
    }
    for (i in save.indices) for (j in save[0].indices) if (cnt < save[i][j]) cnt = save[i][j]
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until M
fun init() {
    for (i in board.indices) for (j in board[0].indices) check[i][j] = false
}