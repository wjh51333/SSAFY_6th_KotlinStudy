fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    val pos = readLine().split(" ").map { it.toInt() }.sorted()

    var answer = 0
    if (k < n) {
        val diff = IntArray(pos.size - 1)
        for (i in 0 until n - 1) {
            diff[i] = pos[i + 1] - pos[i]
        }
        diff.sort()
        for (i in 0 until n - k) {
            answer += diff[i]
        }
    }
    print(answer)
}