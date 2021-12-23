fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val T = readLine().toInt()
    for (t in 1..T) {
        val (h, w, n) = readLine().split(" ").map { it.toInt() }
        var answer = ""

        var tmp = n % h
        var tmp2 = n / h
        if (tmp == 0) {
            answer = h.toString()
            if (tmp2 < 10) answer += "0"
            answer += tmp2.toString()
        }
        else {
            tmp2++
            answer += tmp.toString()
            if (tmp2 < 10) answer += "0"
            answer += tmp2.toString()
        }
        bw.write("$answer\n")
    }
    bw.flush()
}