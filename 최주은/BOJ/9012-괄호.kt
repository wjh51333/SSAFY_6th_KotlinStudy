import java.lang.StringBuilder
import java.util.*

class `9012` {
}

fun main() = with(System.`in`.bufferedReader()) {
    var len = readLine()!!.toInt()

    while (len-- > 0){
        var stack = Stack<Char>()
        var sb:StringBuilder = StringBuilder(readLine())
        var trigger = false

        for (i in sb.indices) {
            if(sb[i] == '(')
                stack.push(sb[i])
            else if(!stack.isEmpty() && sb[i] == ')' && stack.peek() == '(')
                stack.pop()
            else {
                trigger = true
                break
            }
        }

        if(!stack.isEmpty() || trigger) {
            println("NO")
            continue
        }

        println("YES")
    }
}
