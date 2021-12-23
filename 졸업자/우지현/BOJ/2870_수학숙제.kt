import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val arr = mutableListOf<BigInteger>()

    for (i in 1..n) {
        val input = readLine().split(("[^\\d.]").toRegex())
        for (j in input.indices) {
            if (!input[j].equals("")) arr.add(input[j].toBigInteger())
        }
    }

    arr.sort()
    arr.forEach { bw.write("${it}\n") }
    bw.flush()
}