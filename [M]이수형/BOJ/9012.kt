import java.util.*

fun main() = with(Scanner(System.`in`)) {

    for (N in 0 until nextInt()) {
        val temp = next().split("")
        val stack = Stack<String>();
        for (i in temp.indices) {
            when (temp[i]) {
                ")" -> if (stack.isEmpty()) {
                    stack.push(" ")
                    break
                } else if (stack.peek().equals("(")) stack.pop()
                "(" -> stack.push(temp[i])
            }
        }
        println(if (stack.isEmpty()) "YES" else "NO")
    }


}