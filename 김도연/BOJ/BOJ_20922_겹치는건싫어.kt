import java.lang.Integer.max

fun main() {
    val input = readLine()!!.split(" ")
    val N = Integer.parseInt(input[0])
    val K = Integer.parseInt(input[1])

    val count = IntArray(100001)
    val seq = readLine()!!.split(" ")

    var start = 0;  var end = 0; var maxLen = 0
    while (start <= end) {
        if (end >= N)
            break

        val eNum = Integer.parseInt(seq[end])
        if (count[eNum] < K) {
            maxLen = max(maxLen, end - start + 1)
            count[eNum]++
            end++
        } else {
            val dNum = Integer.parseInt(seq[start++])
            count[dNum]--
        }
    }

    println(maxLen)
}
