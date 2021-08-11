import java.util.*

fun main() = with(Scanner(System.`in`)) {
	val M = nextInt()
	val N = nextInt()
	var count = 0
	val map = Array<Array<Int>>(N) { Array<Int>(M) {0} }
	val newNodes = LinkedList<Triple<Int, Int, Int>>()
	for (i in 0 until N) {
		for (j in 0 until M) {
			val tmp = nextInt()
			map[i][j] = tmp
			if (tmp == 1) newNodes.add(Triple(i, j, 0))
		}
	}
	while (newNodes.isNotEmpty()) {
		val now = newNodes.poll()
		val nowX = now.second
		val nowY = now.first
		var countCompare = now.third
		if (countCompare != count) count = countCompare
		if (nowX+1 < M && map[nowY][nowX + 1] == 0) {
			map[nowY][nowX + 1] = 1
			newNodes.add(Triple(nowY, nowX + 1, count + 1))
		}
		if (nowX-1 >= 0 && map[nowY][nowX - 1] == 0) {
			map[nowY][nowX - 1] = 1
			newNodes.add(Triple(nowY, nowX - 1, count + 1))
		}
		if (nowY+1 < N && map[nowY + 1][nowX] == 0) {
			map[nowY + 1][nowX] = 1
			newNodes.add(Triple(nowY + 1, nowX, count + 1))
		}
		if (nowY-1 >= 0 && map[nowY - 1][nowX] == 0) {
			map[nowY - 1][nowX] = 1
			newNodes.add(Triple(nowY - 1, nowX, count + 1))
		}
	}
	
	var flag = 1
	for (i in 0 until N)
		for (j in 0 until M)
			if (map[i][j] == 0) flag = 0
	
	if (flag == 0)	println(-1)
	else			println(count)
}
