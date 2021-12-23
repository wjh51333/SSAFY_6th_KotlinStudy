private var n = 0
private lateinit var tree : IntArray

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    tree = IntArray(n + 1)

    for (i in 0 until n - 1) {
        val input = readLine().split(" ").map { it.toInt() }
        tree[input[0]]++
        tree[input[1]]++
    }

    val q = readLine().toInt()
    for (i in 0 until q) {
        val input = readLine().split(" ").map { it.toInt() }
        var correct = true

        if (input[0] == 1) {
            correct = isCut(input[1])
        }

        println(if (correct) "yes" else "no")
    }
}

private fun isCut(v : Int) : Boolean {
    if (tree[v] > 1)
        return true
    return false
}