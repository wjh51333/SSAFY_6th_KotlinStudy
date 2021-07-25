import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    val testcase = nextInt()
    var sum: Int = 0
    var cnt: Double = 0.0

    for (i in 0 until testcase) {
        val num = nextInt()
        sum = 0
        cnt = 0.0
        val temparr = IntArray(num)
        for (j in 0 until num) {
            temparr[j] = nextInt()
            sum += temparr[j]
        }
        for (k in 0 until num) {
            cnt += if (temparr[k] > (sum / num)) 1.0 else 0.0
        }
        println("%.3f".format((cnt / num)*100)+"%")
    }
}