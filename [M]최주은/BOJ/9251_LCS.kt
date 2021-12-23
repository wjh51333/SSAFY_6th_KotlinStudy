/**
 * https://st-lab.tistory.com/139
 */

package boj.`9251_LCS`

import java.lang.Integer.max

val s1 = readLine()!!.toCharArray()
val s2 = readLine()!!.toCharArray()
var dp = Array(s1.size + 1) { Array(s2.size + 1 ) {-1} }

fun main() {
//    dfs(0, 0, 0)
    print(LCS(s1.size-1, s2.size-1))
}

fun LCS(x:Int, y:Int) : Int{
    if(x == -1 || y == -1) return 0

    // 탐색하지 않은 인덱스
    if(dp[x][y] == -1){
        dp[x][y] = 0


        // 같은 문자열이면 추가
        if(s1[x] == s2[y]){
            dp[x][y] = LCS(x-1, y-1) + 1
        }else{
            dp[x][y] = max(LCS(x-1,y), LCS(x,y-1))
        }
    }

    return dp[x][y]
}

//fun dfs(idx1:Int, idx2:Int, len:Int) {
//    if(idx1 == s1.size-1 && idx2 == s2.size-1){
//        res = max(res, len)
//        return
//    }
//
//    if (s1[idx1] == s2[idx2]){
//        if (idx1 < s1.size-1) dfs(idx1+1, idx2, len+1)
//        if (idx2 < s2.size-1) dfs(idx1, idx2+1, len+1)
//    }else{
//        if (idx1 < s1.size-1) dfs(idx1+1, idx2, len)
//        if (idx2 < s2.size-1) dfs(idx1, idx2+1, len)
//    }
//}
