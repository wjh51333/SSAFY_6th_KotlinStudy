package boj.`14500_테트로미노`

var res = 0
var N = 0
var M = 0
val dy = arrayOf(-1,1,0,0)
val dx = arrayOf(0,0,-1,1)
lateinit var map:Array<Array<Int>>
lateinit var visited:Array<Array<Boolean>>

fun main() = with(System.`in`.bufferedReader()){
    val (a, b) = readLine().split(" ").map { it.toInt() }
    N = a
    M = b
    map = Array(N) { readLine().split(" ").map { it.toInt() }.toTypedArray() }
    visited = Array(N) { Array(M) { false } }

    for(i in 0 until N){
        for (j in 0 until M){
            visited[i][j] = true
            dfs(j,i,1, map[i][j])
            visited[i][j] = false
            check(j, i)
        }
    }

    print(res)
}

fun check(x:Int, y:Int){

    for (i in 0 until 4){
        var trigger = false
        var sum = map[y][x]

        for (j in 0..3){
            if( i == j ) continue

            val yy = y + dy[j]
            val xx = x + dx[j]

            if (xx < 0 || xx >= M || yy < 0 || yy >= N){
                trigger = true
                break
            }

            sum += map[yy][xx]
        }

        if (trigger) continue
        res = if(res > sum) res else sum
    }
}

fun dfs(x:Int, y:Int, size:Int, sum:Int){
    if(size == 4){
        res = if(res>sum) res else sum
        return
    }

    for (i in 0 until 4){
        val xx = x + dx[i]
        val yy = y + dy[i]

        if(xx < 0 || xx >= M || yy < 0 || yy >= N || visited[yy][xx]) continue

        visited[yy][xx] = true
        dfs(xx, yy, size+1, sum+map[yy][xx])
        visited[yy][xx] = false
    }
}
