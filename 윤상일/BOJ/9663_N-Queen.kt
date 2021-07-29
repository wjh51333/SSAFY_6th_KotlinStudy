import java.util.*

private lateinit var arr: IntArray
var N = 0
var count = 0

fun main() {
	val sc = Scanner(System.`in`)
	N = sc.nextInt()
	arr = IntArray(N)
	nQueen(0)
	println(count)
}

fun nQueen(depth: Int) {
	// 모든 원소를 다 채운 상태면 count 증가 및 return
	if (depth == N) {
		count++
		return
	}
	for (i in 0 until N) {
		arr[depth] = i
		// 놓을 수 있는 위치일 경우 재귀호출
		if (possibility(depth)) {
			nQueen(depth + 1)
		}
	}
}

fun possibility(col: Int): Boolean {
	for (i in 0 until col) {
		// 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
		if (arr[col] == arr[i]) {
			return false
		} else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
			return false
		}
	}
	return true
}
