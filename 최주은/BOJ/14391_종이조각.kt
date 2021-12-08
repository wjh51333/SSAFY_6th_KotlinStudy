/**
 * https://machine-geon.tistory.com/153
 */

package boj.`14391_종이조각`

import kotlin.math.max

var N = 0
var M = 0
var res = 0
lateinit var map: Array<Array<Int>>
lateinit var visited:Array<Array<Boolean>>

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    N = n
    M = m

    map = Array(N) { readLine()!!.toCharArray().map { it - '0' }.toTypedArray() }
    visited = Array(N) { Array(M) { false } }
    
    dfs(0, 0)
    print(res)
}

fun dfs(row: Int, col: Int) {
    // 탐색 종료
    if(row >= N){
        sum()
        return
    }

    // 하나의 행의 체크 종료 -> 다음 행으로 이동
    if(col >= M){
        dfs(row+1, 0)
        return
    }

    // 가로 탐색
    visited[row][col] = true
    dfs(row, col+1)

    // 세로 가로 탐색
    visited[row][col] = false
    dfs(row, col+1)
}

fun sum() {
    var ret = 0
    var temp = 0

    // 가로 숫자 계산
    for(i in 0 until N){
        temp = 0
        for (j in 0 until M){
            // 가로 덧셈 -> true인 경우
            if(visited[i][j]){
                temp *= 10 // 자리 이동
                temp += map[i][j]
            }else{
                ret += temp
                temp = 0 // temp 초기화
            }
        }
        ret += temp
    }

    // 세로 숫자 계산
    for(i in 0 until M){
        temp = 0
        for (j in 0 until N){
            // 가로 덧셈 -> true인 경우
            if(!visited[j][i]){
                temp *= 10 // 자리 이동
                temp += map[j][i]
            }else{
                ret += temp
                temp = 0 // temp 초기화
            }
        }
        ret += temp
    }

    res = max(res, ret)
}
