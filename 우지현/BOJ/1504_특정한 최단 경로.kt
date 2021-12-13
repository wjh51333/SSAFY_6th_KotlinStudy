import java.util.*

private var n = 0
private var e = 0
private lateinit var graph : Array<MutableList<Pair<Int, Int>>>
private lateinit var dist : Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val info = readLine().split(" ").map { it.toInt() }
    n = info[0]
    e = info[1]

    graph = Array(n + 1) { mutableListOf() }
    for (i in 0 until e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }
        graph[a].add(b to c)
        graph[b].add(a to c)
    }

    val (v1, v2) = readLine().split(" ").map { it.toInt() }
    dist = Array(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
    arrayOf(1, v1, v2).forEach { dijkstra(it) }
    print(shortest(v1, v2))
}

private fun dijkstra(start : Int) {
    val pq = PriorityQueue(compareBy<Pair<Int, Int>>({ it.first }, { it.second }))
    pq.add(0 to start)
    dist[start][start] = 0

    while (pq.isNotEmpty()) {
        val (d, cur) = pq.poll()

        if (dist[start][cur] < d) continue

        graph[cur].forEach {
            val next = it.first
            val nextDist = d + it.second

            if (nextDist < dist[start][next]) {
                dist[start][next] = nextDist
                pq.add(nextDist to next)
            }
        }
    }
}

private fun shortest(a : Int, b : Int) : Int {
    var d = Int.MAX_VALUE

    // 1 -> a -> b -> n
    if (dist[1][a] != Int.MAX_VALUE && dist[a][b] != Int.MAX_VALUE && dist[b][n] != Int.MAX_VALUE)
        d = minOf(d, dist[1][a] + dist[a][b] + dist[b][n])

    // 1 -> b -> a -> n
    if (dist[1][b] != Int.MAX_VALUE && dist[b][a] != Int.MAX_VALUE && dist[a][n] != Int.MAX_VALUE)
        d = minOf(d, dist[1][b] + dist[b][a] + dist[a][n])

    // 경로가 없는 경우
    if (d == Int.MAX_VALUE)
        d = -1

    return d
}