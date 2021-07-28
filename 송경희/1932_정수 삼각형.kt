
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.*
    fun main() = with(Scanner(System.`in`)) {

        var n = nextInt()
        var arr = ArrayList<ArrayList<Int>>()
        var tmparr = ArrayList<Int>()
        for (i in 0..n - 1) {
            for (j in 0..i) {
                tmparr.add(nextInt())
            }
            arr.add(tmparr)
            tmparr = arrayListOf()
        }
        var dp = Array<IntArray>(n, {IntArray(n)})
        for (i in 0 until n) {
            dp[n - 1][i] = arr[n - 1][i]
        }
        println("${find(0, 0, dp, arr, n)}")
    }

fun find(depth: Int, idx: Int, dp:Array<IntArray>, arr: ArrayList<ArrayList<Int>>,n : Int): Int {
        if (depth == n - 1)
            return dp[depth][idx]

        if (dp[depth][idx] == 0) {
            dp[depth][idx] = max(find(depth + 1, idx, dp, arr, n), find(depth + 1, idx + 1, dp, arr, n)) + arr[depth][idx]
        }

        return dp[depth][idx]
    }