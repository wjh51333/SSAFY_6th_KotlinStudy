import java.util.*

fun main() = with(Scanner(System.`in`)) {
	val M = nextInt()
	val N = nextInt()
	val map = Array<Array<Char>>(M) { Array<Char>(N) {'0'} }
	val q = LinkedList<Triple<Int, Int, Int>>()
	var tmp:String
	var ans = 0

	for (i in 0 until M) {
		tmp = next()
		for (j in 0 until N) {
			map[i][j] = tmp[j];
		}
	}
	for (i in 0 until M) {
		for (j in 0 until N) {
			if (map[i][j] == 'L') {
				val cache = Array<Array<Int>>(M){ Array<Int>(N) {0} }
				var count = 0
				cache[i][j] = 1
				q.add(Triple(i, j, 0))
				while (q.isNotEmpty()) {
					val now = q.poll()
					val nowY = now.first
					val nowX = now.second
					val depth = now.third
					if (depth != count) count = depth
					if (nowX+1 < N && map[nowY][nowX + 1] == 'L' && cache[nowY][nowX + 1] == 0) {
						cache[nowY][nowX + 1] = 1
						q.add(Triple(nowY, nowX + 1, count + 1))
					}
					if (nowX-1 >= 0 && map[nowY][nowX - 1] == 'L' && cache[nowY][nowX - 1] == 0) {
						cache[nowY][nowX - 1] = 1
						q.add(Triple(nowY, nowX - 1, count + 1))
					}
					if (nowY+1 < M && map[nowY + 1][nowX] == 'L' && cache[nowY + 1][nowX] == 0) {
						cache[nowY + 1][nowX] = 1
						q.add(Triple(nowY + 1, nowX, count + 1))
					}
					if (nowY-1 >= 0 && map[nowY - 1][nowX] == 'L' && cache[nowY - 1][nowX] == 0) {
						cache[nowY - 1][nowX] = 1
						q.add(Triple(nowY - 1, nowX, count + 1))
					}
				}
				ans = ans.coerceAtLeast(count)
			}
		}
	}
	println(ans)
}
