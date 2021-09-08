package boj.`13023_ABCDE`

lateinit var info:List<Int>
lateinit var visited:Array<Boolean>
lateinit var rel:Array<ArrayList<Int>>
var res:Int = 0

fun main() = with(System.`in`.bufferedReader()) {
    info = readLine().split(" ").map { it.toInt() }
    visited = Array(info[0]){ false }
    rel = Array(info[0]) { ArrayList() }

    // 입력받기
    for (i in 0 until info[1]){
        val temp:List<Int> = readLine().split(" ").map { it.toInt() }
        rel[temp[0]].add(temp[1])
        rel[temp[1]].add(temp[0])
    }

    for (i in 0 until info[0]){
        if(res == 0)
            dfs(i, 1)
    }

    print(res)
}

fun dfs(v:Int, cnt:Int){
    if(cnt == 5) {
        res = 1
        return
    }

    visited[v] = true
    rel[v].forEach {
        if(res == 0 && !visited[it])
            dfs(it, cnt+1)
    }
    visited[v] = false

}
