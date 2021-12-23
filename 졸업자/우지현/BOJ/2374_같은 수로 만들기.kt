private var a = intArrayOf()
private var answer = 0.toBigInteger()

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    a = IntArray(n) { readLine().toInt() }
    makeSame(0, n)
    println(answer)
}

private fun makeSame(start : Int, end : Int) {
    if ( a.count { it == a[0] } == a.size || end - start < 1)
        return

    // 최댓값 찾기
    val max = getMax(start, end)

    // 최댓값보다 작으면 쪼개기 -> 같은 수가 아닌 구간을 나눌 수 있다
    var idx = start
    while (idx < end) {
        if (a[idx] != max) { 
            val s = idx
            while (idx < end && a[idx] != max) idx++
            makeSame(s, idx)
            idx--
        }
        idx++
    }

    if ( a.count { it == a[0] } == a.size) return

    // Add 연산
    add(start, end)
}

private fun getMax(start : Int, end : Int) : Int {
    var max = 0
    for (i in start until end) {
        max = maxOf(max, a[i])
    }
    return max
}

private fun add(start: Int, end : Int) {
    var target = 1000000000
    if (start - 1 >= 0) target = minOf(target, a[start - 1])
    if (end < a.size) target = minOf(target, a[end])

    val diff = target - a[start]
    answer += diff.toBigInteger() // Add 연산 횟수 추가
    for (i in start until end) {
        a[i] += diff
    }
}