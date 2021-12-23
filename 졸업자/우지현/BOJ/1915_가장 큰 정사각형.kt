fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { readLine().toCharArray().map { it - '0' }.toIntArray() }

    var answer = 0
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (i - 1 >= 0 && j - 1 >= 0 && arr[i][j] != 0) {
                arr[i][j] = minOf(arr[i - 1][j - 1], minOf(arr[i - 1][j], arr[i][j - 1])) + 1
            }
            answer = maxOf(answer, arr[i][j] * arr[i][j])
        }
    }
    println(answer)
}