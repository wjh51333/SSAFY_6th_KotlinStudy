fun main() {
    val t = readLine()!!.toInt()

    for (i in 1..t) {
        val ans = countZeroOneFromFibo(readLine()!!.toInt())
        println("${ans[0]} ${ans[1]}")
    }
}

fun countZeroOneFromFibo(n :Int) :Array<Int> {
    if (n == 0)
        return arrayOf(1, 0)
    if (n == 1)
        return arrayOf(0, 1)

    val counts = Array(n+1, {Array(2, {0})})

    counts[0][0] = 1
    counts[1][1] = 1
    for (i in 2..n) {
        counts[i][0] = counts[i-1][0] + counts[i-2][0]
        counts[i][1] = counts[i-1][1] + counts[i-2][1]
    }

    return counts[n]
}
