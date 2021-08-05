import kotlin.math.*
fun main() {
    val N = readLine()!!.toInt()
    val temp = 2.0.pow(log2(N.toDouble()).toInt()).toInt()
    print(if (N == 1) 1 else if (N % temp == 0) N else (N - temp) * 2)
}