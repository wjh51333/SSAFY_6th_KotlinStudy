import java.util.*
import kotlin.system.exitProcess

fun main() {
	val sc = Scanner(System.`in`)
	val arr = ArrayList<Pair<Int, Int>>()
	val board = Array(9) { IntArray(9) }
	for (i in board.indices) {
		for (j in board[i].indices) {
			board[i][j] = sc.nextInt()
			if (board[i][j] == 0) {
				arr.add(Pair(i, j))	// 빈곳의 좌표
			}
		}
	}

	dfs(board, arr, 0)
}

private fun dfs(board: Array<IntArray>, arr: ArrayList<Pair<Int, Int>>, idx: Int) {
	if (idx == arr.size) {
		for (i in board.indices) {
			for (j in board.indices) {
				print(board[i][j].toString() + " ")
			}
			println()
		}
		exitProcess(0)
	}

	// 빈 스도쿠판 좌표
	val vacancy = arr[idx]

	for (i in 1..9) {
		if (check(board, vacancy.first, vacancy.second, i)) {
			board[vacancy.first][vacancy.second] = i
			dfs(board, arr, idx + 1)
			board[vacancy.first][vacancy.second] = 0
		}
	}
}

private fun check(a: Array<IntArray>, x: Int, y: Int, n: Int): Boolean {
	for (i in 0..8) {
		if (a[x][i] == n) {
			return false
		}
		if (a[i][y] == n) {
			return false
		}
	}

	val boxX = x / 3 * 3
	val boxY = y / 3 * 3

	for (i in boxX until boxX + 3)
		for (j in boxY until boxY + 3)
			if (a[i][j] == n) return false

	return true
}
