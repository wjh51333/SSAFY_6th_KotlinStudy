package today3


var N = 0
var M = 0
var total = 0
lateinit var board: Array<IntArray>
lateinit var check: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {

    var temp = readLine().split(" ").toTypedArray()
    N = temp[0].toInt()
    M = temp[1].toInt()
    total = 0
    board = Array(N) { IntArray(M) }
    check = BooleanArray(N * M)
    for (i in board.indices) {
        temp = readLine().split("").toTypedArray()
        for (j in board[0].indices) {
            board[i][j] = temp[j + 1].toInt()
        }
    }
    dfs(0)
    println(total)
}

fun dfs(index: Int) {
    if (index == N * M) {
        sum()
        return
    }
    check[index] = true
    dfs(index + 1)
    check[index] = false
    dfs(index + 1)
}

fun sum() {
    var sum = 0
    var save = 0

    // 가로
    for (i in 0 until N) {
        save = 0
        for (j in 0 until M) {
            if (check[i * M + j]) {
                save *= 10
                save += board[i][j]
            } else {
                sum += save
                save = 0
            }
        }
        sum += save
    }

    // 세로
    for (j in 0 until M) {
        save = 0
        for (i in 0 until N) {
            if (!check[i * M + j]) {
                save *= 10
                save += board[i][j]
            } else {
                sum += save
                save = 0
            }
        }
        sum += save
    }
    total = Integer.max(total, sum)
}
