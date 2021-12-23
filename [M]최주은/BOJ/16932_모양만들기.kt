/**
 * [참고] https://velog.io/@kjihye0340/%EB%B0%B1%EC%A4%80-16932-%EB%AA%A8%EC%96%91-%EB%A7%8C%EB%93%A4%EA%B8%B0Java
 * Collection을 잘 사용하지 않고 처음에 array로 그룹 체크를 했다가 틀렸다.
 * Set이나 Map 등 사용법을 정확히 익혀서 문제를 풀자!
 */
package boj.`16932_모양만들기`

import java.awt.Point
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.HashSet
import kotlin.collections.isNotEmpty
import kotlin.collections.map
import kotlin.collections.toTypedArray

val br = BufferedReader(InputStreamReader(System.`in`))
val inputSize = br.readLine().split(" ").map { it.toInt() }.toTypedArray()
val map:Array<Array<Int>> = Array(inputSize[0]){ br.readLine().split(" ").map { it.toInt() }.toTypedArray() }
val group = Array(500002) {0}
val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)
var max = 0

fun main() {
    val zeroQ = LinkedList<Point>()

    // 그룹화
    var groupIdx = 2
    for (i in 0 until inputSize[0]){
        for (j in 0 until inputSize[1]){
            if(map[i][j] == 1){
                grouping(j, i, groupIdx++)
            }else if (map[i][j] == 0) zeroQ.add(Point(j,i))
        }
    }

    val set = HashSet<Int>()

    // 계산
    while (zeroQ.isNotEmpty()){
        set.clear()
        val p = zeroQ.poll()
        var calc = 1
        for (k in 0 until 4){
            val xx = p.x + dx[k]
            val yy = p.y + dy[k]

            if(xx < 0 || xx >= inputSize[1] || yy < 0 || yy >= inputSize[0]) continue
            val curGroup = map[yy][xx]
            if(curGroup>1 && !set.contains(curGroup)) {
                calc += group[map[yy][xx]]
                set.add(curGroup)
            }
        }
        max = if(max < calc) calc else max
    }

    print(max)
}

fun grouping(x: Int, y: Int, groupIdx: Int) {
    val queue = LinkedList<Point>()
    queue.add(Point(x, y))
    map[y][x] = groupIdx

    var groupSize = 1

    while (queue.isNotEmpty()){
        val p = queue.poll()

        for (i in 0 until 4){
            val xx = p.x + dx[i]
            val yy = p.y + dy[i]

            if(xx < 0 || xx >= inputSize[1] || yy < 0 || yy >= inputSize[0] || map[yy][xx] != 1) continue
            map[yy][xx] = groupIdx
            queue.add(Point(xx,yy))
            groupSize++
        }
    }

    group[groupIdx] = groupSize
}
