/**
 * 풀이
 * 1. 주변에 같은 숫자들은 하나의 그룹(하나의 숫자)로 압축하여 list에 1개만 넣어준다.
 * 2. 전략을 세워 숫자들을 1씩 증가시키고 같은 숫자는 버린다
 */

package boj.`2374_같은수로만들기`

import java.util.*
import java.util.Collections.min

var N:Int = readLine()!!.toInt()
var list = mutableListOf<Long>()
var res = 0L

fun main() = with(System.`in`.bufferedReader()) {

    // 입력받기
    for (i in 0 until N){
        if(list.isEmpty()){
            list.add(readLine().toLong())
            continue
        }

        val num = readLine().toLong()
        if(list[list.size-1] == num) continue
        list.add(num)
    }

    // 같은 수 만들기
    while(list.size != 1){
        val m = min(list)
        var idx = list.indexOf(m)

        if(idx == 0) {
            res += (list[1] - list.removeAt(idx))
            continue
        }

        if(idx == list.size - 1){
            res += (list[idx-1] - list.removeAt(idx))
            continue
        }

        val pre = list[idx-1]
        val next = list[idx+1]

        res += if(pre <= next){
            list[idx] = pre
            (pre - m)
        }else{
            list[idx] = next
            (next - m)
        }

        // idx 기준 우측 중복제거
        while(true) {
            if (idx + 1 >= list.size || list[idx + 1] != list[idx]) break
            list.removeAt(idx + 1)
        }

        // idx 기준 좌측 중복제거
        while (true) {
            if (idx - 1 < 0 || list[idx-1] != list[idx]) break
            list.removeAt(--idx)
        }
    }

    println(res)
}
