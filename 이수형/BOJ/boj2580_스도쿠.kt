package today2

import java.util.*

var cnt = 0
lateinit var board: Array<Array<Int>>
fun main() = with(Scanner(System.`in`)) {
    board = Array(9) { Array(9) { nextInt() } }
    dfs(0, 0)
}

fun dfs(row: Int, col: Int) {
    //8,8 다음은 9,0이므로 여기오면 다돈것
    if (row == 9 && col == 0) {
        //하나만 출력해주기위해 사용 출력했으면 cnt가 올라가므로 출력더이상X
        if (cnt == 0) {
            board.forEach { it.forEach { print("$it ") };println() }
            cnt++
        }
        //윗부분을 이렇게 하면 더빠르고 메모리가 적음 도대체왜????
        //생각 잘못해서 굳이 필요없는 코드인데...?
        //여러번 실행시켜봐도 이게 무조건 시간빠르고 메모리가 적음
//        if (cnt == 0) {
//            board.forEach { it.forEach { if (it == 0) cnt++ } }
//            if (cnt == 0) {
//                board.forEach { it.forEach { print("$it ") };println() }
//                cnt++
//            }
//        }
        return
    }
    //0인 지점 찾으면 백트래킹
    if (board[row][col] == 0) {
        for (i in 1..9) {
            // 1~9숫자를 체크해보고 들어갈수있으면
            if (checkrowcol(row, col, i) && check3x3(row, col, i)) {
                //숫자를 넣고
                board[row][col] = i
                // col이 끝이아니라면 다음 열로 끝이라면 다음행의 0번으로
                if (col != 8) dfs(row, col + 1) else dfs(row + 1, 0)
            }
        }
        //끝나면 다시 0으로 돌려놓기
        board[row][col] = 0
        return
    }
    // 0이 아닐때 그냥 넘어가기
    if (col != 8) dfs(row, col + 1) else dfs(row + 1, 0)

}

//가로세로 검사
fun checkrowcol(row: Int, col: Int, num: Int): Boolean {
    for (i in 0..8) {
        if (board[row][i] == num) return false
        if (board[i][col] == num) return false
    }
    return true
}

//3*3 격자검사
fun check3x3(row: Int, col: Int, num: Int): Boolean {
    for (i in row / 3 * 3 until row / 3 * 3 + 3) {
        for (j in col / 3 * 3 until col / 3 * 3 + 3) {
            if (board[i][j] == num) return false
        }
    }
    return true
}

