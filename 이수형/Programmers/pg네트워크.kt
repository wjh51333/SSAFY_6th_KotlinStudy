var cnt = 0
fun solution(n: Int, computers: Array<IntArray>): Int {
    val total = IntArray(n)
    val visited = Array(n) { false }
    for (i in visited.indices) {
        if (!visited[i]) dfs(visited, computers, i, total)
    }
    cnt = 0
    total.forEach { if (it == 0) cnt++ }
    return cnt + 1
}

fun dfs(visited: Array<Boolean>, computers: Array<IntArray>, start: Int, total: IntArray) {
    visited[start] = true;
    for (i in visited.indices) {
        if (!visited[i] && computers[start][i] == 1) {
            dfs(visited, computers, i, total)
            cnt++
        }
    }
    total[cnt]++
}

//fun main() {
//    val n = 3
//    val computers = arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1))
////    val n = 4
////    val computers =
////        arrayOf(intArrayOf(1, 1, 1, 1), intArrayOf(1, 1, 1, 0), intArrayOf(1, 1, 1, 0), intArrayOf(1, 0, 0, 1))
//    print(solution(n, computers))
//}