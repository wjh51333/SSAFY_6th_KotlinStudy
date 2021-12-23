import java.lang.Math.max
import java.lang.Math.min

fun main() {
    var input = readLine()!!.split(" ")

    val n = input[0].toInt()
    val m = input[1].toInt()
    val arr = Array(n){Array(m){0} }


    for (i in 0 until n) {
        input = readLine()!!.chunked(1)
        for (j in input.indices)
            arr[i][j] = input[j].toInt()
    }

    var max = 0
    for (i in 0 until m)
        max = max(max, arr[0][i])
    for (i in 0 until n)
        max = max(max, arr[i][0])

    for (i in 1 until n) {
        for (j in 1 until m) {
            if (arr[i][j] != 0) {
                arr[i][j] = min(arr[i-1][j-1], min(arr[i-1][j], arr[i][j-1])) + 1
                max = max(max, arr[i][j])
            }
        }
    }

    println(max*max)
}
