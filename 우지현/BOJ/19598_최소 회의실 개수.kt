import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val time = mutableListOf<Pair<Int, Int>>()

    for (x in 1..n) {
        val (start, end) = readLine().split(" ").map { it.toInt() }
        time.add(Pair<Int, Int>(start, end))
    }

    // 시작 시간에 대해 오름차순으로 정렬
    time.sortWith(compareBy({it.first}, {it.second}))

    val pq = PriorityQueue<Int>()
    pq.add(time[0].second)  // 첫 회의의 끝나는 시간을 우선순위 큐에 넣는다
    for (x in 1 until n) {
        // 이전 회의의 끝나는 시간과 같거나 그 이후여야 같은 회의실을 쓸 수 있다
        // 다음에 진행할 수 있는 회의면 이전 회의를 우선순위 큐에서 꺼낸다
        if (time[x].first >= pq.peek()) {
            pq.poll()
        }
        // 현재 회의를 우선순위 큐에 넣는다
        pq.add(time[x].second)
    }
    println(pq.size) // 우선순위 큐에 남아있는 회의의 수가 최소 회의실 개수
}