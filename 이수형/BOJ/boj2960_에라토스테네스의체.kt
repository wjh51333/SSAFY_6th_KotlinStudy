import java.util.*

var arr = Array<Boolean>(2000) { false }

fun main() = with(Scanner(System.`in`)) {
    prime(nextInt(), nextInt())
}

fun prime(N: Int, end: Int) {
    var cnt = 0
    for (i in 2..N) {
        for (j in i..N step i) {
            if (!arr[j]) {
                arr[j] = true
                if (++cnt == end) {
                    println(j)
                    return
                }
            }
        }

    }
}
