fun main() {
    val N = readLine()!!
    val list = readLine()!!.split(" ").map { it.toInt() }.sorted().toMutableList()
    var sum = 0
    for (i in 1 until list.size) list[i] = list[i] + list[i - 1]
    list.forEach { sum += it }
    print(sum)
}