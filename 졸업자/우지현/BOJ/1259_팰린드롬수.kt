fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    while (true) {
        val num = readLine()
        if (num == "0") break

        val n = num.length - 1
        var palindrome = true
        for (x in 0 until num.length / 2) {
            if (num[x] != num[n - x]) {
                palindrome = false;
                break;
            }
        }
        if (palindrome) bw.write("yes\n")
        else bw.write("no\n")
    }
    bw.flush()
}