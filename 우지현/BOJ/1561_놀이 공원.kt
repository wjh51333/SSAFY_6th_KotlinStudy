fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toLong() }
    val time = readLine().split(" ").map { it.toLong() }
    var answer = n

    if (n > m) {
        var left = 0L
        var right = n * time.maxOf { it }.toLong()

        while (left <= right) {
            // 아이들 모두가 놀이기구를 탈 수 있는 시간
            val mid = (left + right) / 2

            var total = m
            time.forEach { t -> total += mid / t }

            if (total >= n) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        var total = m
        time.forEach { t -> total += (left - 1) / t }

        var k = n - total
        var last = 0

        while (k > 0) {
            if (left % time[last] == 0L)
                k--
            last++
        }
        answer = last.toLong()
    }
    print(answer)
}