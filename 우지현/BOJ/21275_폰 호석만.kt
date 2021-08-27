private val map = mutableMapOf<Char, Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val (A, B) = readLine().split(" ")
    init()

    val maxA = getMax(A) // 최소 A
    val maxB = getMax(B) // 최소 B

    var x = 0L
    var (a, b, cnt) = arrayOf(0, 0, 0)

    for (i in maxA..36) {
        for (j in maxB..36) {
            if (i == j) continue
            val resA = calc(A, i) // A진법 -> 10진법
            val resB = calc(B, j) // B진법 -> 10진법

            // Long 범위이어야함
            if (resA > Long.MAX_VALUE || resB > Long.MAX_VALUE) continue

            if (resA == resB) { // 결과가 같으면 정보 저장
                a = i
                b = j
                x = resA
                cnt++
            }
        }
    }

    if (cnt == 0) println("Impossible") // 만족하는 경우가 없음
    else if (cnt == 1) println("$x $a $b") // X, A, B가 유일하게 존재
    else println("Multiple") // 만족하는 경우가 2가지 이상
}

private fun init() {
    val num = "0123456789"
    num.forEachIndexed { index, c -> map[c] = index }
    for (x in 0 until 26) { map['a' + x] = x + 10 }
}

private fun getMax(s : String) : Int = s.maxOf { map[it]!! + 1 }

private fun calc(s : String, n : Int) : Long {
    var result = 0L
    var mult = 1L
    for (i in s.length-1 downTo 0) {
        result += map[s[i]]!! * mult
        mult *= n
    }
    return result
}