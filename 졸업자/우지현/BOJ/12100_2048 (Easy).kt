private var n = 0
private lateinit var map : Array<IntArray>
private lateinit var org : Array<IntArray>
private lateinit var merged : Array<BooleanArray>

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    org = Array(n) { IntArray(n) }
    merged = Array(n) { BooleanArray(n) }
    println(go(mutableListOf()))
}

private fun go(dir : MutableList<Int>) : Int {
    if (dir.size == 5) {
        saveOrg()
        dir.forEach { move(it) }

        var result = 0
        for (i in map.indices) {
            result = maxOf(result, map[i].maxOrNull()!!)
        }
        backToOrg()
        return result
    }

    saveOrg()

    var max = 0
    for (d in 0 until 4) {
        dir.add(d)
        max = maxOf(max, go(dir))
        dir.removeLast()
    }
    return max
}

private fun saveOrg() {
    for (i in map.indices) {
        for (j in map[i].indices) {
            org[i][j] = map[i][j]
        }
    }
}

private fun backToOrg() {
    for (i in map.indices) {
        for (j in map[i].indices) {
            map[i][j] = org[i][j]
        }
    }
}

private val possible = { nx : Int, ny : Int, x : Int, y : Int ->
    map[nx][ny] == 0 || (!merged[nx][ny] && !merged[x][y] && map[nx][ny] == map[x][y])
}

private fun move(dir : Int) {
    for (i in merged.indices) {
        merged[i].fill(false)
    }

    when (dir) {
        0 -> { // 상
            for (i in 1 until n) {
                for (j in 0 until n) {
                    var x = i
                    while (x - 1 >= 0 && possible(x - 1, j, x, j)) {
                        if (map[x - 1][j] == 0) {
                            map[x - 1][j] = map[x][j].also { map[x][j] = map[x - 1][j] }
                        } else {
                            merged[x - 1][j] = true
                            map[x - 1][j] *= 2
                            map[x][j] = 0
                        }
                        x--
                    }
                }
            }
        }
        1 -> { // 하
            for (i in n - 2 downTo 0) {
                for (j in 0 until n) {
                    var x = i
                    while (x + 1 < n && possible(x + 1, j, x, j)) {
                        if (map[x + 1][j] == 0) {
                            map[x + 1][j] = map[x][j].also { map[x][j] = map[x + 1][j] }
                        } else {
                            merged[x + 1][j] = true
                            map[x + 1][j] *= 2
                            map[x][j] = 0
                        }
                        x++
                    }
                }
            }
        }
        2 -> { // 좌
            for (j in 1 until n) {
                for (i in 0 until n) {
                    var y = j
                    while (y - 1 >= 0 && possible(i, y - 1, i, y)) {
                        if (map[i][y - 1] == 0) {
                            map[i][y - 1] = map[i][y].also { map[i][y] = map[i][y - 1] }
                        } else {
                            merged[i][y - 1] = true
                            map[i][y - 1] *= 2
                            map[i][y] = 0
                        }
                        y--
                    }
                }
            }
        }
        3 -> { // 우
            for (j in n - 2 downTo 0) {
                for (i in 0 until n) {
                    var y = j
                    while (y + 1 < n && possible(i, y + 1, i, y)) {
                        if (map[i][y + 1] == 0) {
                            map[i][y + 1] = map[i][y].also { map[i][y] = map[i][y + 1] }
                        } else {
                            merged[i][y + 1] = true
                            map[i][y + 1] *= 2
                            map[i][y] = 0
                        }
                        y++
                    }
                }
            }
        }
    }
}