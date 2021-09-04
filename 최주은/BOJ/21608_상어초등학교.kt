/**
 * 알고리즘 순서
 * 학생들 정보 받아서 해쉬맵에 넣어줌 => students
 * 첫번째 학생은 무조건 1,1 자리에 배치한 후
 * 1. 뒤에 들어오는 학생들은 좋아하는 학생이 있는 자리의 옆에 가중치 먼저 설정
 * 2. 가중치가 설정된 자리 주변에 빈자리가 있다면 해당 자리 가중치를 높여준다.
 * 3. 가충치 맵에서 가장 큰 가중치를 가졌는 값을 꺼내놓고 해당 자리에 학생을 앉힌다.
 * ( 큐를 사용하였으므로 가중치가 같은 자리가 있더라도 가창 처음에 선택(가장 작은 열)이 poll 하게되므로 2-3번을 동시에 처리 )
 * 질문 => 반례존재? nullpoint가 뜨는 이유..?
 */

package boj.`21608_상어초등학교`

import java.awt.Point
import java.util.*
import kotlin.math.pow

var N:Int = 0
var res:Int = 0
var students:HashMap<Int,IntArray> = HashMap<Int,IntArray>()
var dy: Array<Int> = arrayOf(-1, 1, 0, 0)
var dx: Array<Int> = arrayOf(0, 0, -1, 1)
lateinit var map: Array<IntArray>

fun main() = with(System.`in`.bufferedReader()) {

    N = readLine().toInt()
    map = Array(N){IntArray(N){0} }
    for(i in 0 until N*N){
        var st:StringTokenizer = StringTokenizer(readLine(), " ")
        var info:IntArray = IntArray(4)

        // 저장
        var s:Int = st.nextToken().toInt()
        info[0] = st.nextToken().toInt()
        info[1] = st.nextToken().toInt()
        info[2] = st.nextToken().toInt()
        info[3] = st.nextToken().toInt()
        students[s] = info

        // 자리선정
        if(i == 0)
            map[1][1] = s
        else
            choiceSeat(s)
    }
//
//    for (i in 0 until N){
//        for (j in 0 until N) {
//            print(map[i][j])
//        }
//        println()
//    }
//    println()

    for (i in 0 until N){
        for (j in 0 until N){
            var cnt:Int = 0
            for (k in 0 until 4){
                var x = j + dx[k]
                var y = i + dy[k]
                if(isWall(x,y)) continue
                if(students[map[i][j]]!!.contains(map[y][x])) cnt++
            }
            if (cnt == 0) continue
            res += 10.0.pow(cnt-1).toInt()
        }
    }
    print(res)
}

fun choiceSeat(s:Int){
    var values:Array<IntArray> = Array(N){IntArray(N)} // 가산점을 갱신시킬 배열
    var queue:Queue<Point> = LinkedList<Point>()
    var max:Int = 0

    // 이미 채워진 자리는 -1로 수정한다.
    for (i in values.indices){
        for (j in values[0].indices){
            if(map[i][j] != 0)
                values[i][j] = -1
        }
    }

    // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    for (i in values.indices){
        for (j in values[0].indices){
            if(values[i][j] != -1){
                for (k in dy.indices){
                    var x:Int = j + dx[k]
                    var y:Int = i + dy[k]

                    if(!isWall(x,y) && students[s]!!.contains(map[y][x])) {
                            values[i][j]++
                    }
                }

                if(max < values[i][j]){
                    queue.clear()
                    max = values[i][j]
                    queue.offer(Point(j,i))
                } else if( max == values[i][j]) {
                    queue.offer(Point(j,i))
                }
            }
        }
    }

    if(queue.size == 1){
        var p:Point = queue.poll()
        map[p.y][p.x] = s
        return
    }else max = 0

    // 2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
    queue.forEach{
        for (k in dx.indices){
            var x:Int = it.x + dx[k]
            var y:Int = it.y + dy[k]

            if(!isWall(x, y) && values[y][x] != -1){
                values[it.y][it.x]++
            }
        }
        if(max < values[it.y][it.x]) max = values[it.y][it.x]
    }

    queue.clear()
    for (i in values.indices){
        for (j in values[0].indices){
            if(values[i][j] == max)
                queue.offer(Point(j,i))
        }
    }

    // 자리 정하기
    var p:Point = queue.poll()
    map[p.y][p.x] = s
}

fun isWall(x:Int, y:Int):Boolean{
    if(x < 0 || x >= N || y < 0 || y >= N)
        return true
    return false
}
