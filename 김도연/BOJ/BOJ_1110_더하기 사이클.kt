import java.util.*

// 문제를 잘 읽자
fun main() {
    val sc:Scanner = Scanner(System.`in`)

    val n = sc.nextInt()

    var count = 1
    var pre = n % 10
    var next = n / 10 + n % 10
    while(pre * 10 + next != n) {
        count++
        val tmp = pre
        pre = next
        next = (tmp + next) % 10
    }

    println(count)
}
