import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = Integer.parseInt(readLine())
    val temp = IntArray(N) { i -> i + 1 }
    val queue: Queue<Int> = LinkedList<Int>() // 여기서 바로 초기화할순없을까?

    for (i in 0 until N) {
        queue.add(temp[i])
    }
    for (i in 0 until N-1) {
        queue.remove()
        queue.add(queue.remove())
    }
    println(queue.peek())


}