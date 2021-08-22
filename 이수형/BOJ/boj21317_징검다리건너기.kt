//DP 여러가지 참고함
import java.util.*

var K = 0
lateinit var energy: Array<Array<Int>>
lateinit var dp: Array<Array<Int>>
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt() - 1
    //energy의 0은 1칸가는데드는 에너지 1은 2칸가는데 드는 에너지
    energy = Array<Array<Int>>(N) { Array<Int>(2) { nextInt() } }
    dp = Array<Array<Int>>(N + 2) { Array<Int>(2) { Int.MAX_VALUE } }
    //3칸가는데 드는 에너지
    K = nextInt()
    dp[0][0] = 0
    dp[0][1] = 0
    for (i in 0 until N) {
        for (j in 1..3) if (i + j <= N) makedp(i, j)
    }
    print(dp[N][0].coerceAtMost(dp[N][1]))
}
fun makedp(index: Int, cnt: Int) {
    // 한번만 점프해야되니깐 dp[index][0]+K를 dp[index+3][1]로 넣고비교함
    if (cnt == 3) dp[index + cnt][1] = dp[index + cnt][1].coerceAtMost(dp[index][0] + K)
    else if (cnt == 2) for (i in 0..1) dp[index + cnt][i] = dp[index + cnt][i].coerceAtMost(dp[index][i] + energy[index][1])
    else  for (i in 0..1) dp[index + cnt][i] = dp[index + cnt][i].coerceAtMost(dp[index][i] + energy[index][0])
}
//
//import java.util.*
//var N = 0
//var K = 0
//var result = Integer.MAX_VALUE
//lateinit var energy: Array<Array<Int>>
//fun main() = with(Scanner(System.`in`)) {
//    N = nextInt() - 1
//    energy = Array<Array<Int>>(N) { Array<Int>(2) { nextInt() } }
//    K = nextInt()
//    jump(0, 0, false)
//    print(result)
//}
//fun jump(sum: Int, cnt: Int, big: Boolean) {
//    if (cnt > N) return
//    if (cnt == N) {
//        result = result.coerceAtMost(sum)
//        return
//    }
//    //1칸움직인것
//    jump(sum + energy[cnt][0], cnt + 1, big)
//    //2칸움직인것
//    jump(sum + energy[cnt][1], cnt + 2, big)
//    //3칸은 한번만되므로 big이 true면 안뛰고 아니면 뜀
//    if (!big) jump(sum + K, cnt + 3, true)
//}