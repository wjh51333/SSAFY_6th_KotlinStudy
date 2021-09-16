private var n = 0
private var m = 0
private lateinit var arr : List<Int>

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }
    arr = readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    var left = 0
    var right = arr.maxOf { it }
    var answer = right

    while (left <= right) {
        var mid = (left + right) / 2 // 구간의 점수 최댓값
        if (check(mid)) { // 점수가 사용 가능한지 검사
            answer = minOf(answer, mid) // 구간의 점수 최댓값의 최솟값 갱신
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    println(answer)
}

private fun check(mid : Int) : Boolean {
    var cnt = 1
    var min = arr[0]
    var max = arr[0]

    for (i in 1 until n) {
        min = minOf(min, arr[i])
        max = maxOf(max, arr[i])

        // 구간의 점수가 성립하지 않으면 구간 개수 추가
        if (max - min > mid) {
            max = arr[i]
            min = arr[i]
            cnt++
        }
    }
    return cnt <= m
}
