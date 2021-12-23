fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = 0
    var sum = 0
    var answer = Int.MAX_VALUE

    while (left <= right && right <= n) {
        if (sum < s) { // s보다 작으면 다음 수를 더해준다
            if (right == n) break // 범위가 넘으면 종료
            sum += arr[right++] // 다음 수 더하고 포인터를 옮긴다
        } else {
            answer = minOf(answer, right - left) // 최소 길이 갱신
            sum -= arr[left++] // 제일 첫번째 수를 빼고 포인터를 옮긴다
        }
    }
    println("${if (answer == Int.MAX_VALUE) 0 else answer}")
}