fun main() = with(System.`in`.bufferedReader()) {
    val (x, y, w, h) = readLine().split(" ").map { it.toInt() }
    var answer = minOf(x, w - x)
    answer = minOf(answer, minOf(y, h - y))
    println(answer)
}