import kotlin.system.exitProcess

fun main() {
    val arr = Array(9){IntArray(9)}

    for (i in arr.indices) {
        var input = readLine()!!.split(" ")
        for (j in input.indices)
            arr[i][j] = input[j].toInt()
    }

    dfs(0, 0, arr)

}

fun dfs(x : Int, y : Int, arr : Array<IntArray>) {
    if (y == 9) {
        dfs(x+1, 0, arr)
        return
    }

    if (x == 9) {
        for (i in arr.indices) {
            for (j in arr[i].indices)
                print("${arr[i][j]} ")
            println()
        }
        exitProcess(0)
    }

    if (arr[x][y] == 0) {
        for (n in 1..9) {
            if (isNotExist(x, y, n, arr)) {
                arr[x][y] = n
                dfs(x, y+1, arr)
                arr[x][y] = 0
            }
        }
    } else {
        dfs(x, y+1, arr)
    }
}

fun isNotExist(x : Int, y : Int, n : Int, arr : Array<IntArray>) : Boolean {
    for (i in arr[x].indices) {
        if (arr[x][i] == n)
            return false
        if (arr[i][y] == n)
            return false
    }

    val startX = (x / 3) * 3
    val startY = (y / 3) * 3
    for (i in startX..(startX+2))
        for (j in startY..(startY+2))
            if (arr[i][j] == n)
                return false

    return true
}