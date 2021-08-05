private var graph = arrayOf<MutableList<Int>>()
private var cnt = arrayOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val (N, R, Q) = readLine().split(" ").map { it.toInt() }
    graph = Array(N + 1) { mutableListOf() }
    cnt = Array(N + 1) { 0 }

    for (i in 1 until N) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    dfs(R)

    for (i in 1..Q) {
        bw.write("${cnt[readLine().toInt()]}\n")
    }
    bw.flush()
}

private fun dfs(v : Int) {
    cnt[v] = 1
    graph[v].forEach {
        if (cnt[it] == 0) {
            dfs(it)
            cnt[v] += cnt[it]
        }
    }
}