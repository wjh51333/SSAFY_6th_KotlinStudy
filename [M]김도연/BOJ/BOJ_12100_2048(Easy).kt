import java.lang.Math.max

var answer: Int = 0

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    dfs(0, arr)

    println(answer)
}

fun dfs(start: Int, arr: Array<IntArray>) {
    if (start == 5) {
        findMax(arr)
        return
    }

    for (i in 1..4) {
        val copyArr = move(i, arr)
        dfs(start+1, copyArr)
    }
}

fun move(dir: Int, arr: Array<IntArray>): Array<IntArray> {
    val result = Array(arr.size) { IntArray(arr.size) }
    for (i in arr.indices) {
        result[i] = arr[i].clone()
    }

    when(dir) {
        1 -> {  // up
            trans(result)
        }
        2 -> {  // down
            trans(result)
            reverse(result)
        }
        4 -> {  // right
            reverse(result)
        }
    }

    for (i in result.indices) {
        var idx = 0
        val temp = IntArray(result[i].size)
        var flag = -1

        for (j in result[i].indices) {
            if (result[i][j] != 0) {
                if (flag < 0) {
                    temp[idx] = result[i][j]
                    flag = idx++
                } else {
                    if (temp[flag] == result[i][j]) {
                        temp[flag] *= 2
                        flag = -1
                    } else {
                        temp[idx] = result[i][j]
                        flag = idx++
                    }
                }
            }
        }
        result[i] = temp
    }

    when(dir) {
        1 -> {  // up
            trans(result)
        }
        2 -> {  // down
            reverse(result)
            trans(result)
        }
        4 -> {  // right
            reverse(result)
        }
    }

    return result
}

fun trans(arr: Array<IntArray>) {
    for (i in arr.indices) {
        for (j in i + 1 until arr[i].size) {
            val temp = arr[i][j]
            arr[i][j] = arr[j][i]
            arr[j][i] = temp
        }
    }
}

fun reverse(arr: Array<IntArray>) {
    for (i in arr.indices) {
        arr[i].reverse()
    }
}

fun findMax(arr: Array<IntArray>) {
    var max = 0
    arr.forEach {
        max = max(max, it.maxOf { it })
    }

    if (max > answer)
        answer = max
}