import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val tops = readLine()!!.split(" ").map { it.toInt() }
    val receive = Array(n) { 0 }

    val stack = Stack<Int>()
    var i = 0
    while (i < tops.size) {
        if (stack.isEmpty()) {
            receive[i] = 0
            stack.push(i++)
        } else if (tops[stack.peek()] > tops[i]) {
            receive[i] = stack.peek()+1
            stack.push(i++)
        } else {
            stack.pop()
        }
    }

    for (r in receive)
        print("$r ")
}