class Solution {
    private lateinit var visited:Array<Boolean>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        visited = Array<Boolean>(n){false}

        for (i in visited.indices) {
            if (visited[i])
                continue
            DFS(i, computers)
            answer++
        }
        return answer
    }

    fun DFS(v:Int, computers:Array<IntArray>){
        if(visited[v])
            return

        visited[v] = true

        for (i in 0 until computers[0].size) {
            if (!visited[i] && computers[v][i] == 1)
                DFS(i, computers)
        }
    }
}
