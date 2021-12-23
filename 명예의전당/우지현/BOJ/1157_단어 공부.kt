fun main() = with(System.`in`.bufferedReader()) {
    val word = readLine().uppercase()
    val map = mutableMapOf<Char, Int>()
    val alpha = mutableListOf<Char>()

    word.forEach {
        if (!map.containsKey(it)) {
            map[it] = 1
            alpha.add(it)
        }
        else map[it] = map.getValue(it) + 1
    }

    var max = 0
    var maxCnt = 0
    var maxAlpha = ' ';

    for (x in alpha.indices) {
        val num = map.getValue(alpha[x])
        if (num >= max) {
            if (num == max) maxCnt++
            else {
                maxAlpha = alpha[x]
                max = num
                maxCnt = 1
            }
        }
    }

    if (maxCnt > 1) println("?")
    else println("$maxAlpha")
}