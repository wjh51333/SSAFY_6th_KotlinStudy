fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    while (true) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }.sorted()

        if (a == 0 && b == 0 && c == 0)
            break;

        if (c * c == a * a + b * b) bw.write("right\n")
        else bw.write("wrong\n")
    }
    bw.flush()
}