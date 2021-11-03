private var graph = arrayOf<MutableList<Int>>()
private var visited = booleanArrayOf()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    graph = Array(n) { mutableListOf() }
    visited = BooleanArray(n)
    for (i in 0 until m) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    var answer = 0
    for (i in 0 until n) {
        if (dfs(i, 1)) { // ABCDE 친구 관계가 있다면 종료
            answer = 1
            break
        }
    }
    println(answer)
}

private fun dfs(v : Int, cnt : Int) : Boolean {
    if (cnt >= 5) return true // ABCDE 친구 관계 만족
    visited[v] = true

    graph[v].forEach {
        if (!visited[it] && dfs(it, cnt + 1)) {
            return true
        }
    }

    visited[v] = false
    return false
}