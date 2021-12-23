import java.util.*


fun main() {
    val k = readLine()!!.toInt()
    val stack = Stack<Int>()

    var n :Int;
    for (i in 1..k) {
        n = readLine()!!.toInt()
        if (n == 0 && !stack.isEmpty())
            stack.pop()
        else
            stack.push(n)
    }

    var sum = 0
    while (!stack.isEmpty()) {
        sum += stack.pop()
    }

    println(sum)
}
