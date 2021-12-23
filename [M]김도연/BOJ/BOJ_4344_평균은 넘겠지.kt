import java.text.DecimalFormat
import java.util.*

fun main() {
    val sc:Scanner = Scanner(System.`in`)

    val C = sc.nextInt()
    for (i in 1..C) {
        val n = sc.nextInt()
        val scores:Array<Int> = Array(n) { j -> sc.nextInt() }
        //val scores = IntArray(n)

        var avg:Double = 0.0
        for (j in 0 until n) {
            //scores[j] = sc.nextInt()
            avg += scores[j]
        }
        avg /= n

        var per:Float = 0f
        for (score in scores) {
            if (score > avg) {
                per++
            }
        }
        per = per/n * 100

        val dec = DecimalFormat("#0.000")   // 0.000%를 대비해서 일의 자리까지 반드시 출력으로 해줘야 한다.
        println("${dec.format(per)}%")

    }
}
