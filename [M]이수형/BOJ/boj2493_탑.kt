import java.util.*

fun main() {
    readLine()
    val st = readLine()!!.split(" ")
    val stack = Stack<Array<Int>>()
    for (i in st.indices) {
        val temp = st[i].toInt()
        while (stack.isNotEmpty()) {
            if (temp > stack.peek()[0]) stack.pop()
            else {
                print("${stack.peek()[1]} ")
                break
            }
        }
        if (stack.isEmpty()) print("0 ")
        stack.push(arrayOf(temp, i + 1))
    }
}