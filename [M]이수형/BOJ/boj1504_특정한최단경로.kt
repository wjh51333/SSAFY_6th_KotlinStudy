package today4

import java.util.*

data class node(val end: Int, val weight: Int) : Comparable<node> {
    override fun compareTo(other: node): Int = weight - other.weight
}

lateinit var dist: Array<Int>
lateinit var check: Array<Boolean>
var list = ArrayList<ArrayList<node>>()

//아무리봐도 맞아서 계속 확인했더니 INF값 떄문에 계속 문제가 있었음;;
var INF = 99999999

fun main() {
    val (N, E) = readLine()!!.split(" ").map { it.toInt() }

    repeat(N + 1) {
        list.add(ArrayList())
    }
    repeat(E) {
        val (start, end, weight) = readLine()!!.split(" ").map { it.toInt() }
        list[start].add(node(end, weight))
        list[end].add(node(start, weight))
    }

    val (v1, v2) = readLine()!!.split(" ").map { it.toInt() }
    var go1 = dijkstra(1, v1, N) + dijkstra(v1, v2, N) + dijkstra(v2, N, N)
    var go2 = dijkstra(1, v2, N) + dijkstra(v2, v1, N) + dijkstra(v1, N, N)

    if (go1 >= INF && go2 >= INF) {
        print(-1)
    } else {
        print(Integer.min(go1, go2))
    }
}

fun dijkstra(start: Int, end: Int, N: Int): Int {
    dist = Array(N + 1) { INF }
    check = Array(N + 1) { false }
    val q = PriorityQueue<node>()
    q.add(node(start, 0))
    dist[start] = 0

    while (q.isNotEmpty()) {
        var temp = q.poll()
        var cur = temp.end
        if (!check[cur]) {
            check[cur] = true
            list[cur].forEach {
                if (!check[it.end] && (dist[it.end] > dist[cur] + it.weight)) {
                    dist[it.end] = dist[cur] + it.weight
                    q.add(node(it.end, dist[it.end]))
                }
            }
        }
    }
    return dist[end]
}

