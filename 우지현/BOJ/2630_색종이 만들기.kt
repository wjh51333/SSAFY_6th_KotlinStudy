val N = readLine()!!.toInt()
val paper = Array<IntArray>(N) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
val answer = IntArray(2)
fun main() {
    solve(0, 0, N);
    answer.forEach { println(it) }
}

fun solve(x : Int, y : Int, size : Int) {
    if (size == 1 || sameColor(x, y, size)) {
        answer[paper[x][y]]++
        return
    }

    val nsize = size / 2
    for (k in 0 until 4) {
        solve(x + k / 2 * nsize, y + k % 2 * nsize, nsize)
    }
}

fun sameColor(x : Int, y : Int, size : Int) : Boolean {
    val color = paper[x][y]
    for (i in x until x + size) {
        for (j in y until y + size) {
            if (paper[i][j] != color)
                return false
        }
    }
    return true
}