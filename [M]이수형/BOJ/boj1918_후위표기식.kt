import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var stack = Stack<String>()
    var st = nextLine().split("")
    var make = ""
    for (i in st.indices) {
        when (st[i]) {
            "(" -> stack.push(st[i])
            "*" -> {
                while (stack.isNotEmpty() && ismd(stack.peek())) make += stack.pop()
                stack.push(st[i])
            }
            "/" -> {
                while (stack.isNotEmpty() && ismd(stack.peek())) make += stack.pop()
                stack.push(st[i])
            }
            "+" -> {
                while (stack.isNotEmpty() && ispm(stack.peek())) make += stack.pop()
                stack.push(st[i])
            }
            "-" -> {
                while (stack.isNotEmpty() && ispm(stack.peek())) make += stack.pop()
                stack.push(st[i])
            }
            ")" -> {
                while (stack.peek() != "(") make += stack.pop()
                stack.pop()
            }
            else -> make += st[i]
        }
    }
    while (stack.isNotEmpty()) make += stack.pop()
    println(make)
}

fun ismd(x: String): Boolean = x == "*" || x == "/"
fun ispm(x: String): Boolean = x == "*" || x == "/" || x == "+" || x == "-"