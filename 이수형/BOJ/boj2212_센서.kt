package today4

import java.util.*


fun main() = with(Scanner(System.`in`)) {
    var N = nextInt()
    var K = nextInt()
    var load = Array(N) { nextInt() }.sortedArray()
    var diff = Array(N - 1) { 0 }
    var temp = load[0]
    for (i in 1 until N) {
        diff[i - 1] = load[i] - temp
        temp = load[i]
    }
    diff.sort()
    if (K >= N) {
        print(0)
    } else {
        var total = 0
        for (i in 0 until N - K) {
            total += diff[i]
        }
        println(total)
    }

}
