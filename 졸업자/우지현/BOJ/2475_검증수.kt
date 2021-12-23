fun main() = with(System.`in`.bufferedReader()) {
    val arr = readLine().split(" ").map { it.toInt() }
    var answer = 0
    arr.forEach { answer += it * it }
    println(answer % 10)
}