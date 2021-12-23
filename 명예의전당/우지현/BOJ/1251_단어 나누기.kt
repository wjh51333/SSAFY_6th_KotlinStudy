fun main() = with(System.`in`.bufferedReader()) {
    val word = readLine()
    var answer = ""
    for (i in 1 until word.length - 1) {
        val tmp = mutableListOf<Char>()
        // 첫 번째 단어
        tmp.addAll(word.substring(0, i).reversed().map { it.toChar() })

        for (j in i + 1 until word.length) {
            val result = tmp.toMutableList()
            // 두 번째 단어
            result.addAll(word.substring(i, j).reversed().map { it.toChar() })
            // 세 번째 단어
            result.addAll(word.substring(j, word.length).reversed().map { it.toChar() })

            // 사전순으로 앞서면 갱신
            if (answer.isBlank() || answer.compareTo(result.joinToString("")) > 0)
                answer = result.joinToString("")
        }
    }
    println(answer)
}