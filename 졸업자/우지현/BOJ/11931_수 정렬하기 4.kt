fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val n = readLine().toInt()
    val arr = IntArray(n) { readLine().toInt() }
    arr.sortDescending()
    arr.forEach { bw.write("$it\n") }
    bw.flush()
}