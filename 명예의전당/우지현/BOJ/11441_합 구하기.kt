fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val a = readLine().split(" ").map { it.toInt() }.toIntArray()

    for (x in 1 until a.size) a[x] += a[x - 1]

    val m = readLine().toInt()
    for (x in 1..m) {
        val (i, j) = readLine().split(" ").map { it.toInt() - 1 }
        if (i == 0) bw.write("${a[j]}\n")
        else bw.write("${a[j] - a[i - 1]}\n")
    }
    bw.flush()
}