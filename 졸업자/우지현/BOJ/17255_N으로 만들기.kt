private lateinit var n : String
private var visited = mutableSetOf<String>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine()

    for (i in n.indices) {
        go(i, n[i].toString(), n[i].toString())
    }

    print(visited.size)
}

private fun go(idx : Int, now : String, past : String) {
    if (now == n) {
        visited.add(past)
        return
    }

    if (now.length == n.length)
        return

    if (idx > 0) {
        val next = n[idx - 1] + now
        go(idx - 1, next, past + next)
    }

    if (idx + now.length < n.length) {
        val next = now + n[idx + now.length]
        go(idx, next, past + next)
    }
}