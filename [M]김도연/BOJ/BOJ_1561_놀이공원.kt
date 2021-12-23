fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    if (n <= m) {
        println(n)
        return
    }

    var left = 0L
    var right = 60_000_000_000L

    while (left <= right) {
        val middle = (left + right) / 2

        var people = m.toLong()
        for (i in arr.indices) {
            people += middle / arr[i]
        }

        if (people >= n)    right = middle - 1
        else                left = middle + 1
    }

    var count = m
    for (i in arr.indices) {
        count += (right / arr[i]).toInt()
    }
    for (i in arr.indices) {
        if ((right+1) % arr[i] == 0L)
            count++

        if (count == n) {
            println(i+1)
            break
        }
    }
}