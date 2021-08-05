import java.util.*
import kotlin.math.max

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    val N = nextInt()
    val M = nextInt()
    var max: Int = 0
    var temp: Int = 0
    val arr = IntArray(N) { nextInt() }

    for (i in 0 until N - 2) {
        for (j in i+1 until N - 1) {
            for (k in j+1 until N) {
                temp = arr[i] + arr[j] + arr[k]
                if (temp <= M){
                    max = max(max, temp)
                    println("$i $j $k = $max ")
                }


            }
        }
    }
    print(max)
}