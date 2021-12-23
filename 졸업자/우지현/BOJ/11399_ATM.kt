fun main() {
    val n = readLine()!!.toInt()
    val p = readLine()!!.split(" ").map { it.toInt() }.sorted().toMutableList()
    var answer = p[0]
    for (i in 1 until n) {
        p[i] += p[i - 1]
        answer += p[i]
    }
    println("$answer")
}