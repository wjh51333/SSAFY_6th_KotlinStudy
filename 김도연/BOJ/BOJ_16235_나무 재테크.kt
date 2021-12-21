fun main() {
    val input = readLine()!!.split(" ")
    val N = input[0].toInt()
    val M = input[1].toInt()
    val K = input[2].toInt()

    val A = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
    val map = Array(N) { Array (N) { 5 } }
    val trees = Array(N) { Array (N) { ArrayList<Int>() } }

    for (i in 1..M) {
        val tree = readLine()!!.split(" ").map { it.toInt() }
        trees[tree[0]-1][tree[1]-1].add(tree[2])
    }

    val dx = arrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
    val dy = arrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

    for (year in 1..K) {
        // 봄
        val success = Array(N) { Array(N) { 0 } }
        for (i in trees.indices) {
            for (j in trees.indices) {
                for (t in (trees[i][j].size-1) downTo 0) {
                    if (map[i][j] >= trees[i][j][t]) {
                        map[i][j] -= trees[i][j][t]
                        trees[i][j][t]++
                        success[i][j]++
                    }
                }
            }
        }

        // 여름
        for (i in trees.indices) {
            for (j in trees.indices) {
                for (t in 0 until (trees[i][j].size - success[i][j])) {
                    map[i][j] += trees[i][j][t] / 2
                }
                for (t in 0 until (trees[i][j].size - success[i][j])) {
                    trees[i][j].removeAt(0)
                }
            }
        }

        // 가을
        for (i in trees.indices) {
            for (j in trees.indices) {
                for (t in trees[i][j].indices) {
                    if (trees[i][j][t] % 5 != 0)
                        continue

                    for (d in dx.indices) {
                        val ni = i + dx[d]
                        val nj = j + dy[d]

                        if (ni < 0 || ni >= N || nj < 0 || nj >= N)
                            continue

                        trees[ni][nj].add(1)
                    }
                }
            }
        }

        // 겨울
        for (i in trees.indices) {
            for (j in trees.indices) {
                map[i][j] += A[i][j]
            }
        }
    }

    var count = 0
    for (i in trees.indices) {
        for (j in trees[i].indices) {
            count += trees[i][j].size
        }
    }

    println(count)
}

fun clone(src : Array<Array<Int>>): Array<Array<Int>> {
    val result = Array(src.size) { Array(src.size) { 0 } }

    src.forEachIndexed { index, ints ->
        result[index] = ints.clone()
    }

    return result
}