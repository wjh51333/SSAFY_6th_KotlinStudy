import java.util.*

var ans = 2500

fun main() {
    val input = readLine()!!.split(" ")
    val n = input[0].toInt()
    val m = input[1].toInt()

    val map = Array(n) {
        readLine()!!.split(" ").map { it.toInt()}.toIntArray()
    }

    val list = mutableListOf<Pair<Int, Int>>()
    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 1) {
                map[i][j] = -1
            } else if (map[i][j] == 2) {
                list.add(Pair(i, j))
                map[i][j] = 0
            }
        }
    }

    selectLoc(0, m, 0, list, mutableListOf(), map)

    println(if (ans == 2500) -1 else ans)
}

fun selectLoc(count:Int, end:Int, sIdx: Int,
              list: MutableList<Pair<Int, Int>>, selected: MutableList<Pair<Int, Int>>, arr: Array<IntArray>) {
    if (count == end) {
        val copyArr = copy(arr)
        diffusion(selected, copyArr)
    }

    for (i in sIdx until list.size) {
        selected.add(list[i])
        selectLoc(count+1, end, i+1, list, selected, arr)
        selected.removeLast()
    }
}

fun copy(arr: Array<IntArray>): Array<IntArray> {
    val result = Array(arr.size) { IntArray(arr[0].size) }

    for (i in arr.indices) {
        result[i] = arr[i].clone()
    }

    return result
}

object d {
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)
}

fun diffusion(list: MutableList<Pair<Int, Int>>, arr: Array<IntArray>) {
    val queue: Queue<State> = LinkedList()
    val checked = Array(arr.size) { BooleanArray(arr[0].size) }
    var time = 0

    for (item in list) {
        queue.add(State(item, 0))
        checked[item.first][item.second] = true
    }

    while (queue.isNotEmpty()) {
        val nState = queue.remove()
        time =nState.time
        arr[nState.loc.first][nState.loc.second] = time
        checked[nState.loc.first][nState.loc.second] = true

        for (i in d.dx.indices) {
            val nx = nState.loc.first + d.dx[i]
            val ny = nState.loc.second + d.dy[i]

            if (nx < 0 || nx >= arr.size || ny < 0 || ny >= arr[0].size)
                continue

            if (arr[nx][ny] == 0 && !checked[nx][ny]) {
                checked[nx][ny] = true
                arr[nx][ny] = time + 1
                queue.add(State(Pair(nx, ny), time+1))
            }
        }
    }

    if (isComplete(checked, arr) && time < ans) {
        ans = time
    }
}

fun isComplete(checked: Array<BooleanArray>, arr: Array<IntArray>): Boolean {
    for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (!checked[i][j] && arr[i][j] == 0)
                return false
        }
    }
    return true
}

data class State(val loc: Pair<Int, Int>, val time: Int)


// 반례
/*
5 2
1 1 1 1 1
1 1 2 1 1
1 1 2 1 1
1 1 1 1 1
1 1 1 1 1

0
*/