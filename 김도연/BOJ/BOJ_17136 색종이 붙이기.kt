import kotlin.math.min

val papers = arrayOf(0, 5, 5, 5, 5, 5)
lateinit var map: Array<IntArray>
var minCnt = 26

fun main() {
    map = Array(10){ readLine()!!.split(" ").map { it.toInt() }.toIntArray() }


    dfs(0, 0, 0)

    println(if (minCnt == 26) -1 else minCnt)
}

fun dfs(x: Int, y: Int, cnt: Int) {
    if (cnt >= minCnt)
        return

    if (x == 10) {
        minCnt = min(minCnt, cnt)
        return
    }

    if (y == 10) {
        dfs(x+1, 0, cnt)
        return
    }

    if (map[x][y] == 1) {
        for (size in 5 downTo 1) {
            if (papers[size] == 0) continue
            if(isAttached(x, y, size)) {
                papers[size]--
                attached(x, y, size)
                dfs(x, y+size, cnt+1)
                papers[size]++
                unAttached(x, y, size)
            }
        }
    } else {
        dfs(x, y+1, cnt)
    }
}

fun isAttached(x:Int, y: Int, size: Int): Boolean {
    for (i in x until x+size) {
        for (j in y until y+size) {
            if (i >= 10 || j >= 10)
                return false
            if (map[i][j] != 1)
                return false
        }
    }
    return true
}

fun attached(x:Int, y: Int, size: Int) {
    for (i in x until x+size) {
        for (j in y until y+size) {
            map[i][j] = 2
        }
    }
}

fun unAttached(x:Int, y: Int, size: Int) {
    for (i in x until x+size) {
        for (j in y until y+size) {
            map[i][j] = 1
        }
    }
}