import java.util.*

var M: Int = 0
var N: Int = 0
var K: Int = 0
var dx = arrayOf(0, 0, 1, -1)
var dy = arrayOf(-1, 1, 0, 0)
fun main() = with(Scanner(System.`in`)) {

    var cnt: Int = 0

    var board: Array<Array<Int>>
    var check: Array<Array<Boolean>>
    repeat(nextInt()) {
        M = nextInt()
        N = nextInt()
        K = nextInt()
        cnt = 0;
        board = Array<Array<Int>>(M) { Array<Int>(N) { 0 } }
        check = Array<Array<Boolean>>(M) { Array<Boolean>(N) { false } }

        for (i in 0 until K) {
            board[nextInt()][nextInt()] = 1
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == 1 && !check[i][j]) {
                    dfs(board, check, i, j)
                    cnt++
                }
            }
        }
        println(cnt)
    }
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until M && y in 0 until N

fun dfs(board: Array<Array<Int>>, check: Array<Array<Boolean>>, x: Int, y: Int) {
    check[x][y] = true
    for (i in dx.indices) {
        val newx = x + dx[i]
        val newy = y + dy[i]
        if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 1)
            dfs(board, check, newx, newy)
    }
}