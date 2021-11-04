private var n = 10
private lateinit var paper : Array<IntArray>
private var r = arrayOf(0, 5, 5, 5, 5, 5)
private var answer = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    paper = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    cover(0, 0, 0)
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}

private fun cover(x : Int, y : Int, cnt : Int) {
    if (x >= 9 && y > 9) {
        answer = minOf(answer, cnt)
        return
    }

    if (answer <= cnt) return

    if (y > 9) {
        cover(x + 1, 0, cnt)
        return
    }

    if (paper[x][y] == 0) {
        cover(x, y + 1, cnt)
    } else {
        for (i in 5 downTo 1) {
            if (r[i] > 0 && possible(x, y, i)) {
                paste(x, y, i, 0)
                r[i]--

                cover(x, y + 1, cnt + 1)

                paste(x, y, i, 1)
                r[i]++
            }
        }
    }
}

private fun possible(x : Int,  y : Int, size : Int) : Boolean {
    for (i in x until x + size) {
        for (j in y until y + size) {
            if (isWall(i, j) || paper[i][j] != 1)
                return false
        }
    }
    return true
}

private val isWall = { x : Int, y : Int ->
    x < 0 || x >= n || y < 0 || y >= n
}

private fun paste(x : Int, y : Int, size : Int, state : Int) {
    for (i in x until x + size) {
        for (j in y until y + size) {
            paper[i][j] = state
        }
    }
}