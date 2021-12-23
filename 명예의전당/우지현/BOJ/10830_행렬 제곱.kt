private var n = 0
private const val MOD = 1000
private lateinit var mat : Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {
    val info = readLine().split(" ")
    n = info[0].toInt()
    mat = Array(n) { readLine().split(" ").map { it.toInt() % MOD }.toIntArray() }

    mat = square(info[1].toLong())
    mat.forEach { m ->
        m.forEach { print("$it ") }
        println()
    }
}

private fun square(m : Long) : Array<IntArray> {
    if (m <= 1) return mat

    lateinit var result : Array<IntArray>
    when (m % 2) {
        0L -> {
            val tmp = square(m / 2)
            result = calc(tmp, tmp)
        }
        1L -> {
            val tmp = square(m / 2)
            result = calc(calc(tmp, tmp), mat)
        }
    }
    return result
}

private fun calc(a : Array<IntArray>, b : Array<IntArray>) : Array<IntArray> {
    val result = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until n) {
            var sum = 0
            for (k in 0 until n) {
                sum = (sum + a[i][k] * b[k][j]) % MOD
            }
            result[i][j] = sum
        }
    }
    return result
}