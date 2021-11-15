import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val info = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (p, d) = readLine().split(" ").map { it.toInt() }
        info.add(d to p)
    }
    
    // d 오름차순, p 오름차순으로 정렬
    info.sortWith(compareBy({it.first}, {it.second}))

    val pq = PriorityQueue<Int>(compareBy { it })

    var answer = 0

    for (i in 0 until n) {
        answer += info[i].second;
        pq.add(info[i].second)

        // info[i].first보다 더 많은 경우
        // 하루에 최대 한 곳에서만 강연을 한다는 특성이 지켜지지 않은 것이므로
        // pq에 있는 값 중 가장 작은 강연료 제거
        if (pq.size > info[i].first) {
            answer -= pq.poll()
        }
    }
    println(answer)
}