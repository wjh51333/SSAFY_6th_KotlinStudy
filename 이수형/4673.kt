import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    var cnt: Int = 0
    function().forEach {
        if (it.equals(false)) {
            println("$cnt")
            cnt++
        } else {
            cnt++
        }
    }
}

fun function(): BooleanArray {

    val newarr = BooleanArray(10001)
    var temp: Int = 0;
    var sum: Int = 0;
    for (i in 0 until 10000) {

        temp = i
        sum = i
        while (temp != 0) {
            sum += temp % 10
            temp /= 10
        }
        if (sum <= 10000) {
            newarr[sum] = true
        }
    }
    return newarr;
}