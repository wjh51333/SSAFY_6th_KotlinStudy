package today3

import java.util.*

var N: Int = 0
var B: Long = 0
lateinit var arr: Array<Array<Long>>
fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    B = nextLong()
    arr = Array(N) { Array(N) { nextLong() } }
    multi(B).forEach { it.forEach { print("$it ") }; println() }
}

fun calc(arr1: Array<Array<Long>>, arr2: Array<Array<Long>>, arr3: Array<Array<Long>>): Array<Array<Long>> {
    for (i in 0 until N) {
        for (j in 0 until N) {
            for (k in 0 until N) {
                arr3[i][j] += arr1[i][k] * arr2[k][j]
            }
            arr3[i][j] %= 1000L
        }
    }
    return arr3
}

fun multi(cnt: Long): Array<Array<Long>> {
    var temp = Array(N) { Array(N) { 0L } }
    var temp2 = Array(N) { Array(N) { 0L } }
    val temp3 = Array(N) { Array(N) { 0L } }

    if (cnt == 1L) {
        for (i in 0 until N) for (j in 0 until N) temp[i][j] = arr[i][j] % 1000
        return temp
    }

    temp = multi(cnt / 2)
    temp2 = calc(temp, temp, temp2)

    return if (cnt % 2 == 1L) {
        calc(temp2, arr, temp3)
    } else {
        temp2
    }

}
