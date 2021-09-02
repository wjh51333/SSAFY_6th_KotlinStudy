import java.util.*

fun main() = with(Scanner(System.`in`)) {

    var N = nextInt()
    var M = nextInt()
    var result = 0
    nextLine()
    var board = Array(N) {
        val temp = nextLine()
        Array(M) {
            val num = temp[it].digitToInt()
            //아예 0만들어올경우가 있어 result를 처음에 0으로주고
            //1이하나라도 들어오면 1로 해줌
            if (num == 1) result = 1
            num
        }
    }
    for (i in N - 2 downTo 0) {
        for (j in M - 2 downTo 0) {
            if (board[i][j] == 1) {
                //맨뒤-2 부터 네모로 갱신해 오는데 1,1,1,1 인경우 2로 업글,
                // 다른값이 하나라도있으면 정사각이아니므로 min+1 을통해 표시
                board[i][j] = arrayOf(board[i][j + 1], board[i + 1][j], board[i + 1][j + 1]).minOrNull()!! + 1
                result = result.coerceAtLeast(board[i][j] * board[i][j])
            }
        }
    }
    print(result)

}