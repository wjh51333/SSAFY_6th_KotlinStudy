import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    var sum: Int = 0
    val M = nextInt()
    val N = nextInt()
    var temp: Int = 0

    for (i in N downTo M) {
        sum += if (!primearr()[i]) {
            temp = i
            temp
        } else 0
    }
    print(
        if (sum != 0) {
            "$sum\n$temp"
        } else {
            -1
        }
    )
}

fun primearr(): BooleanArray {
    val save = BooleanArray(10002)
    save[0] = true
    save[1] = true

    for (i in 2 until 10001) {
        if (!save[i]) {
            for (j in 2 * i until 10001 step i) {
                save[j] = true
            }
        }

    }
    return save
}