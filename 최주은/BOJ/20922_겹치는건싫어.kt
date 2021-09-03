package boj.`20922_겹치는건싫어`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st:StringTokenizer = StringTokenizer(readLine(), " ")
    var count:Array<Int> = Array(100001) {0}
    var N:Int = st.nextToken().toInt()
    var K:Int = st.nextToken().toInt()
    var res:Int = 0

    var num: List<Int> = readLine().split(" ").map { it.toInt() }

    var start:Int = 0
    var end:Int = 0

    while (start < num.size && end < num.size ){
        if(count[num[start]] < K){
            count[num[start++]]++

            if(res < Math.abs(end-start))
                res = Math.abs(end-start)
            continue
        }

        count[num[end++]]--
    }

    print(res)
}
