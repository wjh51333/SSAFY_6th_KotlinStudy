import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    print(fac(nextInt()))
}
fun fac(n: Int): Int = if (n < 2) 1 else n * fac(n - 1)