fun main() = with(System.`in`.bufferedReader()) {
    val arr = Array(10) { readLine().toInt() % 42 }.distinct()
    println(arr.size)
}