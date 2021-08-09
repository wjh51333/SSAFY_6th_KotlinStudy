 fun main() = with(System.`in`.bufferedReader()) {
     val bw = System.out.bufferedWriter()
     val (n, m) = readLine().split(" ").map { it.toInt() }
     val sum = Array(n + 2) { IntArray(n + 2) }

     for (i in 1..n) {
         val input = readLine().split(" ").map { it.toInt() }
         for (j in 1..n) {
             sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + input[j - 1]
         }
     }

     for (i in 1..m) {
         val (x1, y1, x2, y2) = readLine().split(" ").map { it.toInt() }
         bw.write("${ sum[x2][y2] - (sum[x2][y1 - 1] + sum[x1 - 1][y2]) + sum[x1 - 1][y1 - 1]}\n")
     }
     bw.flush()
 }