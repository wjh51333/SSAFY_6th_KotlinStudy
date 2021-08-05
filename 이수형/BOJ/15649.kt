import java.util.*

val check = BooleanArray(9) { false }
fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()
    val result = ""
    find(n, m, result)
}

fun find(n: Int, m: Int, result: String) {
    if (result.length >= m * 2) {
        println(result)
        return
    }
    for (i in 1 until n + 1) {
        if (check[i]) continue
        check[i] = true
        find(n, m, "$result$i ")
        check[i] = false
    }
}