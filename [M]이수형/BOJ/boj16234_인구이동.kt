import java.util.*
import kotlin.math.abs

var N = 0
var L = 0
var R = 0
lateinit var board: Array<Array<Int>>
lateinit var check: Array<Array<Boolean>>
var dx = intArrayOf(-1, 1, 0, 0)
var dy = intArrayOf(0, 0, -1, 1)
fun main() {
    var temp = readLine()!!.split(" ")
    N = temp[0].toInt()
    L = temp[1].toInt()
    R = temp[2].toInt()
    board = Array(N) { Array(N) { 0 } }
    check = Array(N) { Array(N) { false } }
    for (i in 0 until N) {
        temp = readLine()!!.split(" ")
        for (j in 0 until N) board[i][j] = temp[j].toInt()
    }
    var total = 0
    var cnt = 0
    while (true) {
        if (cnt == N * N) break
        cnt = 0
        init()
        var result = false
        // 매 반복시마다 board에 bfs를 해서
        // 만약 갱신이 된다면 total을 하나 올려주고
        // 갱신이 안된다면 kk를 올려주어서
        // 위의 kk에서 모든 칸이다 문이 안열리면 끝내게 함
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (!check[i][j]) {
                    if (bfs(i, j)) result = true
                    else cnt++
                }
            }
        }
        if (result) total++
    }
    print(total)
}
// bfs로 돌면서 board를 바꿀수있으면 다바꿔줌
// 만약 바꿨다면 true 안바꿨다면 false
fun bfs(x: Int, y: Int): Boolean {
    //Queue 두개로 하나는 bfs용이고 하나는 값 바꿔주는용으로사용
    //check로 하려니 어차피 현재 열린값을 저장을 시킬 무언가가필요할것같음
    var q = LinkedList<Array<Int>>()
    var q2 = LinkedList<Array<Int>>()
    q.add(arrayOf(x, y))
    q2.add(arrayOf(x, y))
    var sum = board[x][y]
    var cnt = 1
    check[x][y] = true
    while (q.isNotEmpty()) {
        var temp = q.poll()
        for (i in dx.indices) {
            var newx = temp[0] + dx[i]
            var newy = temp[1] + dy[i]
            if (isNotWall(newx, newy) && !check[newx][newy] && abs(board[temp[0]][temp[1]] - board[newx][newy]) >= L
                && abs(board[temp[0]][temp[1]] - board[newx][newy]) <= R
            ) {
                sum += board[newx][newy]
                check[newx][newy] = true;
                q.add(arrayOf(newx, newy))
                q2.add(arrayOf(newx, newy))
                cnt++
            }
        }
    }
    return if (cnt == 1) {
        check[x][y] = false
        false
    } else {
        while (q2.isNotEmpty()) {
            var temp = q2.poll()
            board[temp[0]][temp[1]] = sum / cnt
        }
        true
    }
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until N;
fun init() {
    for (i in check.indices) for (j in check.indices) check[i][j] = false
}