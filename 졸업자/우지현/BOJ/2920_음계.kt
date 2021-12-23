fun main() = with(System.`in`.bufferedReader()) {
    var arr = readLine().split(" ").map { it.toInt() }
    var result = 0
    var before = -2
    for (i in 1 until arr.size) {
        if (arr[i] - arr[i - 1] > 0) result = 1
        else result = -1

        if (before != -2 && result != before) {
            result = 0
            break
        }
        before = result
    }

    when (result) {
        1 -> println("ascending")
        -1 -> println("descending")
        else -> println("mixed")
    }
}