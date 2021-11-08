import java.util.*
import kotlin.collections.HashMap

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val array = Array(n) {Array(m) { sc.nextInt() } }
    val map = HashMap<Int, Int>()

    var groupNum = 2
    for (i in array.indices) {
        for (j in array[i].indices) {
            if (array[i][j] == 1)
                map[groupNum] = bfs(i, j, array, groupNum++)
        }
    }

    var maxSize = map.maxOf { it.value }
    for (i in array.indices) {
        for (j in array[i].indices) {
            if (array[i][j] == 0) {
                val list = mutableListOf<Int>()

                for (k in dx.indices) {
                    val nx = i + dx[k]
                    val ny = j + dy[k]
                    if (isNotWall(nx, ny, array) && array[nx][ny] != 0) {
                        list.add(array[nx][ny])
                    }
                }

                if (list.isNotEmpty()) {
                    var size = 1
                    list.distinct().forEach { size += map[it]?:0 }
                    maxSize = maxOf(maxSize, size)
                }
            }
        }
    }

    println(maxSize)
}

fun bfs(x: Int, y: Int, array: Array<Array<Int>>, num: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(x, y))
    array[x][y] = num
    var size = 1

    while (queue.isNotEmpty()) {
        val point = queue.remove()

        for (i in dx.indices) {
            val nx = point.first + dx[i]
            val ny = point.second + dy[i]

            if (isNotWall(nx, ny, array) && array[nx][ny] == 1) {
                queue.add(Pair(nx, ny))
                array[nx][ny] = num
                size++
            }
        }
    }
    return size
}

fun isNotWall(x: Int, y: Int, array: Array<Array<Int>>): Boolean {
    if (x < 0 || x >= array.size)    return false
    if (y < 0 || y >= array[0].size) return false
    return true
}


//fun main() {
//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()
//    val m = sc.nextInt()
//    val array = Array(n) {Array(m) { sc.nextInt() } }
//
//    var size = 0
//    // 하나 바꾸기
//    for (i in array.indices) {
//        for (j in array[i].indices) {
//            if (array[i][j] == 0) {
//                array[i][j] = 1
//                // dfs로 가장 큰 크기 구하기
//                size = size.coerceAtLeast(getMax(array))
//                array[i][j] = 0
//            }
//        }
//    }
//
//    print(size)
//}

//fun getMax(array: Array<Array<Int>>): Int {
//    val check = Array(array.size) {Array(array[0].size) { false } }
//    var size = 0
//
//    for (i in array.indices) {
//        for (j in array[i].indices) {
//            if (array[i][j] == 1) {
//                size = size.coerceAtLeast(bfs(i, j, array, check))
//            }
//        }
//    }
//    return size
//}

//fun bfs(x: Int, y: Int, array: Array<Array<Int>>, check: Array<Array<Boolean>>): Int {
//    val dx = arrayOf(0, 0, -1, 1)
//    val dy = arrayOf(-1, 1, 0, 0)
//    val queue: Queue<Pair<Int, Int>> = LinkedList()
//
//    check[x][y] = true
//    queue.add(Pair(x, y))
//    var size = 1
//
//    while (queue.isNotEmpty()) {
//        val point = queue.remove()
//
//        for (i in dx.indices) {
//            val nx = point.first + dx[i]
//            val ny = point.second + dy[i]
//
//            if (move(nx, ny, array, check)) {
//                check[nx][ny] = true
//                queue.add(Pair(nx, ny))
//                size++
//            }
//        }
//    }
//
//    return size
//}
//
//fun move(x: Int, y: Int, array: Array<Array<Int>>, check: Array<Array<Boolean>>): Boolean {
//    if (x < 0 || x >= check.size)    return false
//    if (y < 0 || y >= check[0].size) return false
//    if (array[x][y] == 0 || check[x][y])    return false
//    return true
//}