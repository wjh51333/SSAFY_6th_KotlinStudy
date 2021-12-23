private var n = 0
private var m = 0
private lateinit var paper : Array<String>
private lateinit var dir : Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    val info = readLine().split(" ").map { it.toInt() }
    n = info[0]
    m = info[1]

    paper = Array(n) { readLine() }
    dir = Array(n) { BooleanArray(m) }
    print(go(0, ))
}

private fun go(z : Int) : Int {
    if (z >= n * m) {
        return cut()
    }

    val x = z / m
    val y = z % m
    var max = 0

    // 세로
    dir[x][y] = true
    max = maxOf(max, go(z + 1))

    // 가로
    dir[x][y] = false
    max = maxOf(max, go(z + 1))

    return max
}

private fun cut() : Int {
    var sum = 0

    // 가로 (false)
    for (i in 0 until n) {
        var num = ""
        for (j in 0 until m) {
            if (!dir[i][j]) {
                num += paper[i][j]
            } else if (num.isNotEmpty()) {
                sum += num.toInt()
                num = ""
            }
        }
        if (num.isNotEmpty())
            sum += num.toInt()
    }

    // 세로 (true)
    for (j in 0 until m) {
        var num = ""
        for (i in 0 until n) {
            if (dir[i][j]) {
                num += paper[i][j]
            } else if (num.isNotEmpty()) {
                sum += num.toInt()
                num = ""
            }
        }
        if (num.isNotEmpty())
            sum += num.toInt()
    }

    return sum
}