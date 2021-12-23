import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    val K = nextInt()
    var arr = Array<Int>(N) { nextInt() }
    var check = IntArray(100001)
    var start = 0
    var end = 0
    var max = 0
    while (end < N) {
        if (check[arr[end]] >= K) {
            check[arr[start++]]--
        } else {
            check[arr[end++]]++
            max = max.coerceAtLeast(end - start)
        }
    }
    print(max)
}
