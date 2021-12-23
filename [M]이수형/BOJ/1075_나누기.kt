import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var N: Int = nextInt()
    N = (N / 100) * 100
    val F: Int = nextInt()
    var cnt: Int = 1
    while (N % F != 0) N = (N / 100) * 100 + cnt++
    print(if (N % 100 > 9) "${N % 100}" else "0${N % 100}")
}