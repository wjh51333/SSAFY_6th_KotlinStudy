import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    var k = sc.nextInt()

    val coins = Array<Int>(n) {sc.nextInt()}

    var max :Int = 0
    for (i in n-1 downTo 0) {
        if (k / coins[i] != 0) {
            max = i
            break
        }
    }
    var count:Int = 0
    for (i in max downTo 0) {
        count += k / coins[i]
        k %= coins[i]
        if (k == 0)
            break
    }
    println(count)
}
