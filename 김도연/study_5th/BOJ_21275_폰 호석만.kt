fun main() {
    val input = readLine()!!.split(" ")
    val inputA = input[0]
    val inputB = input[1]

    // a,b의 범위 : 각자의 가장 큰 숫자보다 큰 수
    // 조건 1. a != b --> a == b의 경우만 존재하면 impossable
    // 조건 2. a와 b 만족 조합이 2개 이상 --> multiple
    // 조건 3. 2 <= a, b <= 36
    // 조건 4. x <= Long.MAX_VALUE

    val maxA = getMaxChar(inputA) - 'W'
    val maxB = getMaxChar(inputB) - 'W'

    if (maxA == 35 && maxA == maxB) {
        println("Impossible")
    } else {
        var x: Long = 0; var a = 0; var b = 0; var count = 0

        for (i in (maxA+1)..36) {
            for (j in (maxB+1)..36) {
                if (i == j)
                    continue

                var aX = nToDec(inputA, i)
                var bX = nToDec(inputB, j)

                if (aX > Long.MAX_VALUE || bX > Long.MAX_VALUE)
                    continue
                if (aX == bX) {
                    x = aX; a = i; b = j
                    count++
                }
            }
        }

        if (count == 1)
            println("${x} ${a} ${b}")
        else if (count > 1)
            println("Multiple")
        else
            println("Impossible")
    }
}

fun getMaxChar(s: String): Char {
    var max = s[0]
    for (i in 1 until s.length-1) {
        if (s[i] > max)
            max = s[i]
    }
    return max
}

fun nToDec(s: String, n: Int): Long {
    var result: Long = 0;

    for (i in s.indices) {
        result *= n
        result += nToDec(s[i], i)
    }

    return result
}

fun nToDec(c: Char, n :Int): Int {
    return if (c in '0'..'9')
        c - '0'
    else
        c - 'W'
}
