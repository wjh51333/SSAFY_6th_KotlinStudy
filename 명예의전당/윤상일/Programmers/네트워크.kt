class Solution {
	lateinit var nodes:Array<Int>
	fun solution(n: Int, computers: Array<IntArray>): Int {
		var answer = 0
		nodes = Array<Int>(n) {0}
		var flag = 0
		for (i in 0 until n) {
			flag = dfs(computers, n, i)
			if (flag == 1) answer++
		}
		return answer
	}
	
	fun dfs(computers:Array<IntArray>, n:Int, index:Int):Int {
		if (nodes[index]==0) {
			nodes[index] = 1
			for (i in 0 until n) {
				if (nodes[i] == 1) continue
				if (computers[index][i] == 1) dfs(computers, n, i)
			}
			return 1
		}
		return 0
	}
}
