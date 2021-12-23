import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }

    val answer = IntArray(n)
    val st = Stack<Int>()

    st.push(n - 1)
    for (i in n - 2 downTo 0) {
        while (st.isNotEmpty() && arr[i] > arr[st.peek()]) {
            answer[st.peek()] = i + 1
            st.pop()
        }
        st.push(i)
    }
    println(answer.joinToString(" "))
}