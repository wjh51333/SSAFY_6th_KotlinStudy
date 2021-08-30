fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val arr = readLine().split(" ").map { it.toInt() }

    val cnt = IntArray(100001) // 수열에 속한 각 원소의 개수
    var (left, right) = arrayOf(0, 0)
    var answer = 0

    while (right < n) {
        if (cnt[arr[right]] < k) { // k 미만일 때만 추가 가능
            cnt[arr[right]]++
            answer = maxOf(answer, right - left + 1)
            right++
        } else { // 같은 원소가 k 이상 들어있으면 하나씩 제거
            cnt[arr[left]]--
            left++
        }
    }
    println(answer)
}