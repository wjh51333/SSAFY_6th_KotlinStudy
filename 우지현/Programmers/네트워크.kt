class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = mutableListOf<Int>()
        for (v in 0 until n) {
            if (!visited.contains(v)) {
                dfs(n, v, computers, visited)
                answer++
            }
        }
        return answer
    }

    fun dfs(n : Int, v : Int, computers : Array<IntArray>, visited : MutableList<Int>) {
        visited.add(v)
        computers[v].forEachIndexed { next, connected ->
            if (connected == 1 && !visited.contains(next))
                dfs(n, next, computers, visited)
        }
    }
}