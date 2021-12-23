import java.util.*

var total: Long = 0
lateinit var arr: Array<Int>
fun main() {
    val N = readLine()!!.toInt()
    var max = 0
    arr = Array(N) { val temp = readLine()!!.toInt();max = max.coerceAtLeast(temp);temp }
    divide(0, N, max)
    println(total)
}
//분할 정복
fun divide(start: Int, end: Int, save: Int) {
    // 각 단계에서 최대값과 그 index 를 구함
    var max = 0
    var index = 0
    for (i in start until end) {
        if (max < arr[i]) {
            max = arr[i]
            index = i
        }
    }
    // 분할 정복
    // 최대값의 인덱스가 start 뒤에있으면 분할
    if (start < index) divide(start, index, max)
    // 최대값의 인덱스가 end 앞에있으면 분할
    if (end > index + 1) divide(index + 1, end, max)
    //이전 최대값과 지금 작은범위의 최대값을 뺀값을 더해줌
    total += save - max
}
