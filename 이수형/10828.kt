import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

//Scanner 쓰니까 시간초과 떠서 BufferReader로 변경
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val stack = Stack<Int>()
    val N = Integer.parseInt(readLine())

    for (i in 0 until N ) {
        val temp = readLine().split(" ")

        when (temp[0]) {
            "push" -> stack.push(Integer.parseInt(temp[1]))
            "pop" -> println("${if (stack.isEmpty()) -1 else stack.pop()}")
            "size" -> println("${stack.size}")
            "empty" -> println("${if (stack.isEmpty()) 1 else 0}")
            "top" -> println("${if (stack.isEmpty()) -1 else stack.peek()}")
        }
    }


}