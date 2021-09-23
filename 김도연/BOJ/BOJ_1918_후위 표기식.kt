import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val input = sc.nextLine()
    val stack = Stack<Pair<Int, Char>>()

    val sb = StringBuffer()
    for (c in input) {
        when(c) {
            '(' -> stack.add(Pair(0, '('))
            '+' -> {
                while (stack.size > 0 && stack.peek().first >= 1)
                    sb.append(stack.pop().second)
                stack.add(Pair(1, '+'))
            }
            '-' -> {
                while (stack.size > 0 && stack.peek().first >= 1)
                    sb.append(stack.pop().second)
                stack.add(Pair(1, '-'))
            }
            '*' -> {
                while (stack.size > 0 && stack.peek().first >= 2)
                    sb.append(stack.pop().second)
                stack.add(Pair(2, '*'))
            }
            '/' -> {
                while (stack.size > 0 && stack.peek().first >= 2)
                    sb.append(stack.pop().second)
                stack.add(Pair(2, '/'))
            }
            ')' -> {
                while (stack.peek().first != 0)
                    sb.append(stack.pop().second)
                stack.pop()
            }
            else -> sb.append(c)
        }
    }

    while (!stack.isEmpty())
        sb.append(stack.pop().second)

    println(sb.toString())
}