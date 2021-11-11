
fun main() {
    val n = readLine()!!.toInt()
    val vertex = Array(n+1) { 0 }

    for (i in 1 until n) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        vertex[input[0]]++
        vertex[input[1]]++
    }

    val q = readLine()!!.toInt()
    for (i in 1..q) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        when(input[0]) {
            1 -> {
                if (vertex[input[1]] > 1)
                    println("yes")
                else
                    println("no")
            }
            2 -> {
                println("yes")
            }
        }
    }
}

/*
var n = 0
val edge: ArrayList<Pair<Int, Int>> = ArrayList()

fun main() {
    n = readLine()!!.toInt()

    for (i in 1 until n) {
        val uv = readLine()!!.split(" ").map { it.toInt() }
        edge.add(Pair(uv[0], uv[1]))
    }

    val q = readLine()!!.toInt()
    for (i in 1..q) {
        val input = readLine()!!.split(" ").map { it.toInt() }
        when(input[0]) {
            1 -> {
                removeV(input[1])
            }
            2 -> {
                removeE(input[1])
            }
        }
    }
}

fun removeV(v: Int) {
    val isUsed = Array(n+1) { false }
    var flag = false

    isUsed[v] = true

    for (i in 1..n) {
        if (!isUsed[i]) {
            if (flag) {
                println("yes")
                return
            }
            bfs(i, isUsed)
            flag = true
        }
    }

    println("no")
}

fun removeE(e: Int) {
    val isUsed = Array(n+1) { false }
    var flag = false

    val temp = edge.removeAt(e-1)

    for (i in 1..n) {
        if (!isUsed[i]) {
            if (flag) {
                edge.add(e-1, temp)
                println("yes")
                return
            }
            bfs(i, isUsed)
            flag = true
        }
    }

    edge.add(e-1, temp)
    println("no")
}

fun bfs(u: Int, isUsed: Array<Boolean>) {
    val queue: Queue<Int> = LinkedList()

    queue.add(u)
    isUsed[u] = true

    while (queue.isNotEmpty()) {
        val node = queue.remove()

        for (i in edge.indices) {
            val e = edge[i]
            when(node) {
                e.first -> {
                    if (!isUsed[e.second]) {
                        queue.add(e.second)
                        isUsed[e.second] = true
                    }
                }
                e.second -> {
                    if (!isUsed[e.first]) {
                        queue.add(e.first)
                        isUsed[e.first] = true
                    }
                }
            }
        }
    }
}
*/