fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    println(binomial(n, k))
}

private fun binomial(n : Int, k : Int) : Int = if (k == 0 || k == n) 1 else binomial(n -1, k - 1) + binomial(n - 1, k)