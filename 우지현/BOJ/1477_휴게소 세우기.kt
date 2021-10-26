fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, L) = readLine().split(" ").map { it.toInt() }
    val rest = readLine().split(" ").mapNotNull { it.toIntOrNull() }.toMutableList()
    rest.apply {
        addAll(arrayOf(0, L))
        sort()
    }

    var left = 1
    var right = L - 1

    while (left <= right) {
        val mid = (left + right) / 2

        var cnt = 0
        for (i in 0 until rest.size - 1) {
            var tmp = rest[i] + mid
            // rest[i]와 rest[i + 1] 사이에 세울 수 있는 휴게소 개수
            while (tmp < rest[i + 1]) {
                cnt++
                tmp += mid
            }
        }

        if (cnt <= m) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    println(left)
}