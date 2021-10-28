fun main() {

    val (N, S) = readLine()!!.split(" ").map { it.toInt() }
    val temp = readLine()!!.split(" ")
    val board = Array<Int>(N) { temp[it].toInt() }

    var start = 0
    var end = 0
    var sum = 0
    var min = Integer.MAX_VALUE
    while (true) {
        if (start > end) break
        if (end > N) break

        //조건 충족되면 길이를 저장하고 시작지점을 옮기고 옮겨진 앞의값만큼 전체값에서 뺌
        if (sum >= S) {
            min = Integer.min(min, end - start)
            sum -= board[start++]
        //조건이 충족되지 않았을때 계속 더해나가야 되는데 end==N이 되면 범위를 벗어나므로 조정
        } else if (sum < S && end < N) {
            sum += board[end++]
        } else {
            break
        }
    }
    println(if (min == Integer.MAX_VALUE) 0 else min)
}