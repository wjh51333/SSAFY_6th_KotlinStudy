package boj.`21317_징검다리건너기`

val N = readLine()!!.toInt()
val energe:Array<Array<Int>> = Array(N-1) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }
val K = readLine()!!.toInt()
var min = Integer.MAX_VALUE

fun main() {
    dfs(0, 0, true)
    print(min)
}

fun dfs(s:Int, e:Int, t:Boolean){
    if(e >= min) return
    if(s >= N) return

    if(s == N-1){
        min = if(min > e) e else min
        return
    }

    dfs(s+1, e+energe[s][0], t)
    dfs(s+2, e+energe[s][1], t)
    if(t) dfs(s+3, e+K, false)
}
