fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val p = readLine()
    println("${ if (KMP(s, p)) 1 else 0 }")
}

private fun KMP(text : String, pattern : String) : Boolean {
    val m = pattern.length // 찾아야 하는 문자열의 길이
    val n = text.length // 텍스트의 길이
    val pi = fail(pattern) 

    var j = 0
    for (i in 0 until n) {
        while (j > 0 && text[i] != pattern[j]) {
            j = pi[j - 1]
        }

        if (text[i] == pattern[j]) { // 일치한다면
            if (j == m - 1) return true // 이전의 문자도 모두 일치했으므로 검색 성공
            else j++ // 다음 원소 검사
        }
    }
    return false
}

private fun fail(pattern : String) : IntArray {
    val m  = pattern.length
    val pi = IntArray(m) // partial match table

    var j = 0
    for (i in 1 until m) {
        while (j > 0 && pattern[i] != pattern[j]) {
            j = pi[j - 1]
        }

        if (pattern[i] == pattern[j]) {
            pi[i] = ++j
        }
    }
    return pi
}