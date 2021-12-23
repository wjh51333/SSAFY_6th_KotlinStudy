import java.lang.StringBuilder
import java.util.*

private val sb = StringBuilder()
private val st = StringTokenizer(readLine(), " ")
private val n = st.nextToken().toInt()
private val graph = Array<MutableList<Int>> (n + 1) { i -> mutableListOf() }
private val visited = Array<Boolean> (n + 1) { i -> false }


private fun dfs(v : Int) {
    visited[v] = true
    sb.append("$v ")
    graph[v].forEach { if (!visited[it]) dfs(it) }
}

private fun bfs(start : Int) {
    visited.fill(false)
    val q : Queue<Int> = LinkedList()
    q.add(start)
    visited[start] = true

    while (q.isNotEmpty()) {
        val v = q.poll()
        sb.append("$v ")
        graph[v].forEach {
            if (!visited[it]) {
                visited[it] = true
                q.add(it)
            }
        }
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    var m = st.nextToken().toInt()
    val start = st.nextToken().toInt()

    while (m-- != 0) {
        val edge = readLine().split(" ").map { it.toInt() }
        graph[edge[0]].add(edge[1])
        graph[edge[1]].add(edge[0])
    }
    graph.forEach { it.sort() }

    dfs(start)
    sb.append("\n")
    bfs(start)
    println(sb.toString())
}