private val moduler = 1000000007L
fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val scoville = readLine().split(" ").map { it.toInt() }.sorted()

    var answer = 0L
    scoville.forEachIndexed { index, it ->
        val mxcnt = pow(2, index)
        answer += it % moduler * mxcnt % moduler
        val mncnt = pow(2, n - index - 1)
        answer -= it % moduler* mncnt % moduler
        answer = mod(answer, moduler)
    }
    println(answer)
}

private fun pow(n : Int, k : Int) : Long {
    if (k == 0) return 1L
    if (k == 1) return n.toLong()

    val tmp = pow(n, k / 2) % moduler
    if (k % 2 == 0) return tmp * tmp % moduler
    return n * tmp % moduler * tmp % moduler
}

private fun mod(a : Long, b : Long) = ((a % b) + b) % b
