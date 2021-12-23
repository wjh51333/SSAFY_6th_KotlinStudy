import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    val st = Stack<Int>()
    val nge = IntArray(n) { i -> -1 }

    st.push(a.last())
    for (x in n - 2 downTo 0) {
        while (st.isNotEmpty()) {
            if (a[x] < st.last()) {
                nge[x] = st.last()
                break;
            }
            st.pop()
        }
        st.push(a[x])
    }
    print(nge.joinToString(" "))
}