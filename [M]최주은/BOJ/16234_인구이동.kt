package boj.`16234_인구이동`

import kotlin.math.abs

lateinit var group:Array<Int>
lateinit var input:List<Int>
lateinit var map:Array<Array<Int>>
lateinit var visited:Array<Boolean>
var dy:Array<Int> = arrayOf(-1,1,0,0)
var dx:Array<Int> = arrayOf(0,0,-1,1)
var tri:Boolean = false
var res:Int = 0

fun main() = with(System.`in`.bufferedReader()) {
    input = readLine().split(" ").map { it.toInt() } // 0: N, 1: L, 2: R
    map = Array(input[0]) { Array(input[0]) { 0 } }
    group = Array(input[0] * input[0]) { it.toInt() }
    visited = Array(input[0] * input[0]) { false }

    // 입력받기
    map.forEachIndexed { index, _ ->
        map[index] = readLine().split(" ").map { it.toInt() }.toTypedArray()
    }

    while(!tri) {
        // 국경을 열 필요가 있을지 검사한다.
        tri = true
        map.forEachIndexed { i, it ->
            it.forEachIndexed { j, _ ->
                var temp: Int = i * input[0] + j
                if (!visited[temp]) {
                    dfs(j, i)
                }
            }
        }

        // 인구 이동하기
        var cnt:Array<Array<Int>> = Array(input[0]*input[0]) { Array(2) { 0 } }
        // 그룹의 전체 갯수 구하기
        for (i in group.indices){
            var v:Int = find(group[i])
            cnt[v][0]++
            cnt[v][1] += map[i/input[0]][i%input[0]]
        }

        for (i in map.indices){
            for (j in map[0].indices){
                var v:Int = find(group[i*input[0]+j])
                map[i][j] = cnt[v][1] / cnt[v][0]
            }
        }

        visited = Array(input[0] * input[0]) { false }
        Array(input[0] * input[0]) { it.toInt() }
        group = Array(input[0] * input[0]) { it.toInt() }

        if(!tri)
            res++

//        group.forEachIndexed { index, it ->
//            if(index / input[0] == 0)
//                println()
//
//            print("$it ")
//        }
//        println()
    }

    print(res)
}

fun dfs(x:Int, y:Int) {
    if(visited[y*input[0]+x]) return
    visited[y*input[0]+x] = true

    for (k in 0 until 4){
        var xx:Int = x + dx[k]
        var yy:Int = y + dy[k]

        if(isWall(xx, yy)) continue
        var diff:Int = abs(map[y][x] - map[yy][xx])

        // 주변국과 연합해야하는지 판별
        if( diff >= input[1] && diff <= input[2]) {
            tri = false
            var v1: Int = y * input[0] + x
            var v2: Int = yy * input[0] + xx

            union(v1, v2)
            dfs(xx, yy)
        }
    }
}

fun isWall(x:Int, y:Int) : Boolean{
    if (x < 0 || x >= input[0] || y < 0 || y >= input[0])
        return true
    return false
}

fun union(a:Int, b:Int){
    var A = find(a)
    var B = find(b)
    if(A<B) group[B] = A
    else group[A] = B
}

fun find(x:Int) : Int{
    if(group[x] == x) return x
    return find(group[x])
}
