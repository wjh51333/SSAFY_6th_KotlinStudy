import java.util.*
import kotlin.math.sqrt

fun main() = with(Scanner(System.`in`)) {
    var N = nextInt()
    while (true) {
        if (isPal(N.toString()) && isPrime(N)) {
            println(N);
            break
        }
        N++
    }
}

fun isPal(n: String): Boolean = (n == n.reversed())
fun isPrime(n: Int): Boolean {
    if (n == 2)
        return true
    if (n % 2 == 0 || n == 1)
        return false
    for (i in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % i == 0) return false
    }
    return true
}
