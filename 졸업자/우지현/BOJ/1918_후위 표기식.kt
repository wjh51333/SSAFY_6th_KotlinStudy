import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val exp = readLine()
    println(postfix(exp))
}

private fun postfix(exp : String) : String {
    var result = ""
    val ops = Stack<Char>()
    val prior = mapOf<Char, Int>('(' to 0, ')' to 0, '+' to 1, '-' to 1, '*' to 2, '/' to 2)

    exp.forEach {
        when (it) {
            in 'A'..'Z' -> {
                result += it
            }
            '(' -> {
                ops.push(it)
            }
            ')' -> {
                while (ops.isNotEmpty() && ops.peek() != '(') { // (를 만날 때까지 POP
                    result += ops.pop()
                }
                ops.pop()
            }
            else -> {
                // 우선순위가 더 높은 연산자는 pop한 뒤 현재 연산자를 push
                while (ops.isNotEmpty() && prior[ops.peek()]!! >= prior[it]!!) {
                    result += ops.pop()
                }
                ops.push(it)
            }
        }
    }

    // 남은 연산자를 꺼낸다
    while (ops.isNotEmpty()) {
        result += ops.pop()
    }

    return result
}