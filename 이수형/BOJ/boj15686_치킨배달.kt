import kotlin.math.abs

var N = 0
var M = 0
var result = 9999999
lateinit var board: Array<Array<Int>>
lateinit var savehouse: ArrayList<Array<Int>>
lateinit var savechi: ArrayList<Array<Int>>
lateinit var check: Array<Boolean>
fun main() {
    var st = readLine()!!.split(" ")
    N = st[0].toInt()
    M = st[1].toInt()
    board = Array(N) { Array(N) { 0 } }
    savehouse = ArrayList()
    savechi = ArrayList()
    for (i in board.indices) {
        st = readLine()!!.split(" ")
        for (j in board.indices) {
            board[i][j] = st[j].toInt()
            if (st[j].toInt() == 1) savehouse.add(arrayOf(i, j))
            if (st[j].toInt() == 2) savechi.add(arrayOf(i, j))
        }
    }
    check = Array(savechi.size) { false }
    //조합이므로 시작 -1 로하고 start+1을 갱신하며 cnt를세야함
    dfs(-1, 0)
    println(result)
}

// 조합 사용
fun dfs(start: Int, cnt: Int) {

    if (cnt == M) {
        var total = 0
        for (j in savehouse.indices) {
            var min = Integer.MAX_VALUE
            for (i in savechi.indices) {

                if (check[i])
                    min = min.coerceAtMost(abs(savechi[i][0] - savehouse[j][0]) + abs(savechi[i][1] - savehouse[j][1]))
            }
            total += min

        }
        println(total)
        result = result.coerceAtMost(total)
        return
    }
    for (i in start + 1 until check.size) {
        check[i] = true
        dfs(i, cnt + 1)
        check[i] = false
    }
}

//백트래킹 시간초과
//fun dfs(x: Int, y: Int, cnt: Int) {
//    if (cnt == M) {
//        for (j in savehouse.indices) {
//            var min = Integer.MAX_VALUE
//            for (i in savechi.indices) {
//                if (check[savechi[i][0]][savechi[i][1]])
//                    min = min.coerceAtMost(abs(savechi[i][0] - savehouse[j][0]) + abs(savechi[i][1] - savehouse[j][1]))
//            }
//            total += min
//        }
//        result = result.coerceAtMost(total)
//        return
//    }
//    for (i in board.indices) {
//        for (j in board.indices) {
//            if (board[i][j] == 2 && !check[i][j]) {
//                check[i][j] = true
//                dfs(i, j, cnt + 1)
//                check[i][j] = false
//            }
//        }
//    }
//}