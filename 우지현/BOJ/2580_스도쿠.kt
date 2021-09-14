private val c = Array<BooleanArray>(10) { BooleanArray(10) } // 가로
private val c2 = Array<BooleanArray>(10) { BooleanArray(10) } // 세로
private val c3 = Array<BooleanArray>(10) { BooleanArray(10) } // 작은 정사각형
private var sdoku = arrayOf<IntArray>()

fun main() {
    sdoku = Array(9) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (sdoku[i][j] != 0) {
                c[i][sdoku[i][j]] = true
                c2[j][sdoku[i][j]] = true
                c3[square(i, j)][sdoku[i][j]] = true
            }
        }
    }
    go(0)
}

private fun square(x : Int, y : Int) : Int = (x / 3) * 3 + (y / 3)

private fun go(z : Int) : Boolean {
    if (z == 81) {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                print("${sdoku[i][j]} ")
            }
            println()
        }
        return true
    }

    val x = z / 9
    val y = z % 9

    if (sdoku[x][y] != 0) {
        return go(z + 1)
    } else {
        val s = square(x, y)
        for (i in 1 until 10) {
            if (!c[x][i] && !c2[y][i] && !c3[s][i]) {
                c[x][i] = true
                c2[y][i] = true
                c3[s][i] = true
                sdoku[x][y] = i

                if (go(z + 1)) return true

                c[x][i] = false
                c2[y][i] = false
                c3[s][i] = false
                sdoku[x][y] = 0
            }
        }
    }
    return false
}