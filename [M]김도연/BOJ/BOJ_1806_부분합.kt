import java.util.*
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val s = sc.nextInt()
    val arr = Array(n) {sc.nextInt()}

    var start = 0
    var end = 0
    var sum = 0
    var len = n+1

    while(start <= end) {
        if (sum >= s) {
            len = min(len, end - start)
            sum -= arr[start++]
        } else if (end == n) {
            break
        } else {
            sum += arr[end++]
        }
    }

    println(if (len == n+1) 0 else len)
}