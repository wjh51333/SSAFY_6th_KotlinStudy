import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    repeat(N * N) { pq.add(nextInt()) }
    repeat(N - 1) { pq.poll() }
    print(pq.poll())
}