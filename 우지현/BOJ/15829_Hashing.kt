fun main() = with(System.`in`.bufferedReader()) {
    val M = 1234567891
    val n = readLine().toInt()
    val s = readLine()

    var r = 1L
    var answer = 0L
    for (i in s.indices) {
        answer = (answer + (s[i] - 'a' + 1) * r) % M
        r = r * 31 % M
    }
    println(answer)
}