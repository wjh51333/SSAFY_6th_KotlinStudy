import java.util.*

fun main() {
    val sc:Scanner = Scanner(System.`in`)

    var h = sc.nextInt()
    var m = sc.nextInt()

    if (m - 45 < 0) {
        m = 60 + (m - 45)
        h--
    } else {
        m -= 45
    }

    if (h < 0)
        h += 24

    println("$h $m")
}
