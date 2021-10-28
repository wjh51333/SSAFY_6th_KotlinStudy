val digit = arrayListOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
                        , 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' ,'i', 'j'
                        , 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
                        , 'u', 'v', 'w', 'x', 'y', 'z')

fun main() {
    val input = readLine()!!.split(" ")
    val inputA = input[0]
    val inputB = input[1]

    val maxA = getMax(inputA)
    val maxB = getMax(inputB)

    if (maxA == 35 && maxA == maxB) {
        println("Impossible")
    } else {
        var a = 0; var b = 0; var count = 0

        for (i in (maxA+1)..36) {
            for (j in (maxB+1)..36) {
                if (i == j)
                    continue

                var aX = nToDec(inputA, i)
                var bX = nToDec(inputB, j)

                if (aX == bX) {
                    if (aX > Long.MAX_VALUE)
                        continue
                    a = i; b = j
                    count++
                }
            }
        }

        when {
            count == 1 -> println("${nToDec(inputA, a)} $a $b")
            count > 1 -> println("Multiple")
            count == 0 -> println("Impossible")
        }
    }
}

fun getMax(s: String): Int {
    var max = s[0]
    for (i in 1 until s.length) {
        if (s[i] > max)
            max = s[i]
    }
    return digit.indexOf(max)
}

fun nToDec(s: String, n: Int): Long {
    var result: Long = 0;

    for (i in s.indices) {
        result *= n
        result += digit.indexOf(s[i])
    }

    return result
}
