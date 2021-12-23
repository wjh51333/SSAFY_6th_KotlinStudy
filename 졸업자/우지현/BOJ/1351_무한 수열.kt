private val mp = mutableMapOf<Long, Long>()
private var n = 0L
private var p = 0L
private var q = 0L

fun main() = with(System.`in`.bufferedReader()) {
    val info = readLine().split(" ").map { it.toLong() }
    n = info[0]
    p = info[1]
    q = info[2]

    mp[0] = 1
    print(dp(n))
}

private fun dp(n : Long) : Long {
    if (mp.containsKey(n))
        return mp[n]!!

    mp[n] = dp(n / p) + dp(n / q)
    return mp[n]!!
}