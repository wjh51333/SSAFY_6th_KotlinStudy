package BOJ

import java.util.*

fun main() = with(Scanner(System.`in`)) {
	val M = nextInt()
	val N = nextInt()
	val map = Array<String>(0) {""}
	val q = LinkedList<Triple<Int, Int, Int>>()

	for (i in 0 until M) {
		map[i] = next()
	}
	for (i in 0 until M) {
		for (j in 0 until N) {
			if (map[i][j] == 'L') {
				val map2 = map.clone()
				var count = 0
				q.add(Triple(i, j, 0))
				while (q.isNotEmpty()) {
					val now = q.poll()
					val nowY = now.first
					val nowX = now.second
					val depth = now.third
					if (depth != count) count = depth
					if (nowX+1 < M && map2[nowY][nowX + 1] == 'L') {
						map2[nowY][nowX + 1] = 1
						q.add(Triple(nowY, nowX + 1, count + 1))
					}
					if (nowX-1 >= 0 && map2[nowY][nowX - 1] == 0) {
						map2[nowY][nowX - 1] = 1
						q.add(Triple(nowY, nowX - 1, count + 1))
					}
					if (nowY+1 < N && map2[nowY + 1][nowX] == 0) {
						map2[nowY + 1][nowX] = 1
						q.add(Triple(nowY + 1, nowX, count + 1))
					}
					if (nowY-1 >= 0 && map2[nowY - 1][nowX] == 0) {
						map2[nowY - 1][nowX] = 1
						q.add(Triple(nowY - 1, nowX, count + 1))
					}
				}
			}
		}
	}
}
