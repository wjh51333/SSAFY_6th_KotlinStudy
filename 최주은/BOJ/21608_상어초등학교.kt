package boj.`21608_상어초등학교`

import java.awt.Point
import java.util.*
import kotlin.collections.HashMap
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

    for (i in 0 until N){
        for (j in 0 until N){
            var cnt:Int = 0
            var student:Int = map[i][j]

            for (k in 0 until 4){
                var x = j + dx[k]
                var y = i + dy[k]

                if(isWall(x,y)) continue

                for (f in 0 until 4){
                    var friend = students[student]!![f]
                    if(map[y][x] == friend){
                        cnt++
                        break
                    }
                }
            }
            if (cnt == 0) continue
            res += 10.0.pow(cnt-1).toInt()
        }
    }

    print(res)
}

fun choiceSeat(s:Int){
    var values:Array<IntArray> = Array(N){IntArray(N)}
    var queue:Queue<Point> = LinkedList<Point>()
    var max:Int = 0

    for(i in 0 until 4){
        // map을 돌면서 좋아하는 친구를 찾으면 친구 주변의 자리에 가중치를 올려준다. (벽X, 누군가 앉아 있음X)
        for (a in 0 until N){
            for (b in 0 until N){
                if(map[a][b] == students[s]!![i]){
                    for(j in 0 until 4){
                        var yy:Int = a + dy[j]
                        var xx:Int = b + dx[j]

                        // 벽없고 자리가 아닌 곳 가산점
                        if (!isWall(xx,yy) && map[yy][xx] == 0){
                            values[yy][xx]++
                        }
                    }
                }
            }
        }
    }

    for (i in 0 until N){
        for (j in 0 until N) {
            // 주변의 빈자리 가산
            if (values[i][j] != 0) {
                for (k in 0 until 4) {
                    var x: Int = j + dx[k]
                    var y: Int = i + dy[k]

                    if (!isWall(x, y) && map[y][x] == 0) {
                        values[i][j]++
                    }
                }
            }
        }
    }

    for (i in 0 until N){
        for (j in 0 until N) {
            if(max < values[i][j]){
                queue = LinkedList<Point>()
                max = values[i][j]
                queue.add(Point(j, i))
            }else if(max == values[i][j]) {
                queue.add(Point(j, i))
            }
        }
    }

    // 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    var temp:Point = queue.poll()
    map[temp.y][temp.x] = s
}

fun isWall(x:Int, y:Int):Boolean{
    if(x < 0 || x >= N || y < 0 || y >= N)
        return true
    return false
}
