fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toFloat() }
    val m = arr.maxOrNull()
    var avg : Float = 0f
    arr.forEach {
        avg += it / m!! * 100
    }
    println(avg/arr.size)
}