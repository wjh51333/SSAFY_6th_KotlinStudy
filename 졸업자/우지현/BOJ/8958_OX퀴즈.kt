fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val T = readLine().toInt()
    for (t in 1..T) {
        val ox = readLine()
        var cnt = 0
        var answer = 0
        ox.forEach {
            if (it == 'O') {
                cnt++
                answer += cnt
            } else if (it == 'X') {
                cnt = 0
            }
        }
        bw.write("$answer\n")
    }
    bw.flush()
}