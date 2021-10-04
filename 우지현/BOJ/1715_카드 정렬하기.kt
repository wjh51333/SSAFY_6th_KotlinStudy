import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pq = PriorityQueue<Int>() // 오름차순 정렬
    pq.addAll(List<Int>(n) { readLine().toInt() })

    var answer = 0
    while (pq.size > 1) {
        var sum = pq.poll() + pq.poll() // 두 카드 묶음을 합친다
        answer += sum // 두 카드 묶음의 합만큼 비교횟수 증가
        pq.add(sum) // 합친 묶음을 다음 카드 묶음과 합치기 위해 pq에 넣는다
    }
    println(answer)
}