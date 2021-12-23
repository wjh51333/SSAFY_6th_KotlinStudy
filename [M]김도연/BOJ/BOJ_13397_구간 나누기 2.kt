import kotlin.math.*

fun main() {
    var input = readLine()!!.split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()

    val arr = IntArray(n)
    input = readLine()!!.split(" ")

    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    for (i in arr.indices) {
        arr[i] = input[i].toInt()
        min = min(min, arr[i])
        max = max(max, arr[i])
    }

    var left = 0    // 구간의 원소가 하나일 때
    var right = max - min   // 전체 배열에서 구간 점수(이것보다 큰 구간 점수는 없다)
    while (left <= right) {
        var mid = (left + right) / 2

        var setCount = 1
        var setMin = arr[0]
        var setMax = arr[0]
        for (i in 1 until arr.size) {
            setMin = min(setMin, arr[i])
            setMax = max(setMax, arr[i])
            if (setMax - setMin > mid) {
                setCount++
                setMin = arr[i]
                setMax = arr[i]
            }
        }

        if (setCount > m) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    println(left)
}