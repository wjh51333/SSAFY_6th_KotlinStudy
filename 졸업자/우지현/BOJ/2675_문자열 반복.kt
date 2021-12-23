fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    for (x in 1..T) {
        val (tmp, s) = readLine().split(" ")
        val n = tmp.toInt()
        val answer = mutableListOf<Char>()
        for (i in s.indices) {
            for (j in 1..n) { answer.add(s[i]) }
        }
        println(answer.joinToString(""))
    }
}