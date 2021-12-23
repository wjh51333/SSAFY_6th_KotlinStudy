package boj.`17141_연구소2`

import java.util.*

var N = 0
var M = 0
lateinit var map:Array<Array<Int>>
var virus = ArrayList<Point>()
var res = Integer.MAX_VALUE
val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)
var count = 0

data class Point(var y:Int, var x:Int)

fun main() {
    // 초기 셋팅
    var st = StringTokenizer(readLine()!!, " ")
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    map = Array(N){ Array(N){0} }

    for (i in 0 until N){
        st = StringTokenizer(readLine()!!, " ")
        for (j in 0 until N){
            map[i][j] = st.nextToken().toInt()

            if(map[i][j] == 2) {
                virus.add(Point(i, j))
                map[i][j] = 0
                count++
            }

            else if(map[i][j] == 0) count++
            else map[i][j] = -1
        }
    }

    count -= M

    // 넣을 곳이 없으면 안넣어도 됨
    if (count == 0) {
        res = 0
    }else {
        // 바이러스 조합 만들기
        comb(Array(virus.size) { false }, 0, 0)
    }

    // 출력
    print(if(res == Integer.MAX_VALUE) -1 else res)
}

fun comb(visited: Array<Boolean>, start: Int, cnt: Int) {
    if(cnt == M){
        bfs(visited)
        return
    }

    for (i in start until visited.size){
        if (!visited[i]){
            visited[i] = true
            comb(visited, i, cnt+1)
            visited[i] = false
        }
    }
}

fun bfs(visited: Array<Boolean>) {
    // 맵 copy
    val copyM:Array<Array<Int>> = Array(N) { Array(N) {0} }
    for (i in 0 until N) copyM[i] = map[i].clone()

    // Queue 생성
    val queue = LinkedList<Point>()
    for (i in visited.indices) {
        if (visited[i]) {
            queue.add(virus[i])
            copyM[virus[i].y][virus[i].x] = 2
        }
    }

    var time = 0
    var cnt = count
    while (queue.isNotEmpty()){
        if(res <= time) break

        val len = queue.size
        for (i in 0 until len){
            val p = queue.poll()

            for (j in 0 until 4){
                val yy = p.y + dy[j]
                val xx = p.x + dx[j]

                if(xx < 0 || xx >= N || yy < 0 || yy >= N || copyM[yy][xx] != 0) continue

                copyM[yy][xx] = 2
                queue.offer(Point(yy,xx))
                cnt--
            }
        }

        time++
        if (cnt == 0) { // 탐색 불가능
            res = time
            return
        }
    }
}

//
//fun main() {
//    // 초기 셋팅
//    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
//    N = n
//    M = m
//    map = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toTypedArray() }
//
//    // 바이러스 위치 선정 후, 탐색
//    setLocation(0,0,0)
//
//    // 출력
//    res = if (res == Integer.MAX_VALUE) -1 else res
//    print(res)
//}
//
//fun setLocation(a:Int, b:Int, cnt:Int) {
//    if (cnt == M){
//        bfs()
//        return
//    }
//
//    for (i in 0 until N){
//        for (j in 0 until N){
//            if (map[i][j] == 2){
//                map[i][j] = 1
//                queue.push(Point(i, j, 0))
//                setLocation(i,j+1,cnt+1)
//                queue.pollFirst()
//                map[i][j] = 2
//            }
//        }
//    }
//}
//
//fun bfs() {
//    var hnt = -1
//    val copyM = CloneMap()
//    val copyQ = queue.clone() as Queue<Point>
//
//    while (copyQ.isNotEmpty()){
//        val p = copyQ.poll()
//
//        if(res < p.cnt) continue
//
//        copyM[p.y][p.x] = 1
//
//        for (i in 0 until 4){
//            val yy = p.y + dy[i]
//            val xx = p.x + dx[i]
//
//            if(xx < 0 || xx >= N || yy < 0 || yy >= N || copyM[yy][xx] == 1) continue
//
//            copyM[yy][xx] = 1
//            hnt = if(hnt < p.cnt+1) p.cnt+1 else hnt
//            copyQ.offer(Point(yy,xx,p.cnt+1))
//        }
//    }
//
//    copyM.forEach {
//        it.forEach { it2->
//            if (it2 == 0)
//                return
//        }
//    }
//
//    res = if (res > hnt) hnt else res
//}
//
//fun CloneMap() : Array<Array<Int>> {
//    val copyMap = Array(N) { Array(N) {0} }
//
//    for (i in 0 until N){
//        for (j in 0 until N){
//            copyMap[i][j] = map[i][j]
//        }
//    }
//    return copyMap
//}
