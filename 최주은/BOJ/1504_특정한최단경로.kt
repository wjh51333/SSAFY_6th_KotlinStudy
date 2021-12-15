package boj.`1504_특정한최단경로`
import java.lang.Math.min
import java.util.*
import kotlin.collections.ArrayList

var N = 0
var E = 0
var INF = 200000000

lateinit var dis:Array<Int>
lateinit var Edges:Array<ArrayList<Node>>

fun main() {
    val (n, e) = readLine()!!.split(" ").map { it.toInt() }
    N = n
    E = e
    
    Edges = Array(N+1) { ArrayList() }
    dis = Array(N+1) { INF }

    for (i in 0 until E){
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
        Edges[a].add(Node(b,c))
        Edges[b].add(Node(a,c))
    }

    val (V1, V2) = readLine()!!.split(" ").map{ it.toInt() }
    
    val path1 = minPath(1, V1) + minPath(V1, V2) + minPath(V2, N)
    val path2 = minPath(1, V2) + minPath(V2, V1) + minPath(V1, N)
    var res = min(path1, path2)
    res = if (res >= INF) -1 else res
    println(res)
}

fun minPath(start: Int, end: Int):Int{
    val pq = PriorityQueue<Node>()
    for (i in 1..N){
        dis[i] = INF
    }
    
    dis[start] = 0
    pq.add(Node(start, 0))
    
    while (pq.isNotEmpty()){
        val node = pq.poll()
        val nowV = node.v
        val nowDist = node.dist
        
        if (nowDist > dis[nowV]) continue // 현재 입력된 거리보다 더 멀면 X
        
        Edges[nowV].forEach { 
            val nextV = it.v
            val nextDist = dis[nowV] + it.dist
            
            if (dis[nextV] > nextDist) { // 경로 갱신
                dis[nextV] = nextDist
                pq.add(Node(nextV, nextDist))
            }
        }
    }

    return dis[end]
}

class Node(var v: Int, var dist: Int) : Comparable<Node> {
    override operator fun compareTo(o: Node): Int {
        return dist - o.dist
    }
}
