import java.util.*

fun main() {
	val sc = Scanner(System.`in`)
	val N = sc.nextInt()
	val M = sc.nextInt()
	val arr = Array(N) { 0 }
	var max = 10000
	var min = 0
	for (i in arr.indices) {
		arr[i] = sc.nextInt()
		min = Math.min(min, arr[i])
		max = Math.max(max, arr[i])
	}
	var left = 0
	var right = max - min
	while (left <= right) {
		var mid = (left + right) / 2
		if (check(mid, M, arr)) right = mid - 1
		else left = mid + 1
	}
	println(left)
}

fun check(mid:Int, M:Int, arr:Array<Int>):Boolean {
	var groupCnt = 1
	var min = arr[0]
	var max = arr[0]
	for (i in 1 until arr.size) {
		min = Math.min(arr[i], min)
		max = Math.max(arr[i], max)
		if (max - min > mid) {
			min = arr[i]
			max = arr[i]
			groupCnt++
			if (groupCnt > M) return false
		}
	}
	return true
}
