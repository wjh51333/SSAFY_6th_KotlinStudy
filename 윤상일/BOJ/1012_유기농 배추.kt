import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	val T = readLine().toInt()
	repeat(T) {
		val M:Int
		val N:Int
		val K:Int
		readLine().split(" ").let {
			M = it[0].toInt()
			N = it[1].toInt()
			K = it[2].toInt()
		}
		var numbering = 0
		var count = 0
		val checked = Array<Int>(K + 1) { 0 }
		val map = Array<Array<Int>>(N) { Array<Int>(M) { 0 } }
		repeat(K) {
			val x:Int
			val y:Int
			readLine().split(" ").let {
				x = it[0].toInt()
				y = it[1].toInt()
			}
			map[y][x] = ++numbering
		}

		for (y in 0 until N) {
			for (x in 0 until M) {
				if (map[y][x] != 0 && checked[map[y][x]] == 0) {
					dfs(map, checked, x, y, M, N)
					count++
				}
			}
		}
		println(count)
	}
}

private fun dfs(map:Array<Array<Int>>, checked:Array<Int>, x:Int, y:Int, M:Int, N:Int) {
	checked[map[y][x]] = 1
	if ((y == 0 || map[y - 1][x] == 0 || checked[map[y - 1][x]] == 1)
		&& (y == N - 1 || map[y + 1][x] == 0 || checked[map[y + 1][x]] == 1)
		&& (x == 0 || map[y][x - 1] == 0 || checked[map[y][x - 1]] == 1)
		&& (x == M - 1 || map[y][x + 1] == 0 || checked[map[y][x + 1]] == 1))
			return
	if (y != 0 && map[y - 1][x] != 0 && checked[map[y - 1][x]] == 0) dfs(map, checked, x, y - 1, M, N)
	if (y != N - 1 && map[y + 1][x] != 0 && checked[map[y + 1][x]] == 0) dfs(map, checked, x, y + 1, M, N)
	if (x != 0 && map[y][x - 1] != 0 && checked[map[y][x - 1]] == 0) dfs(map, checked, x - 1, y, M, N)
	if (x != M - 1 && map[y][x + 1] != 0 && checked[map[y][x + 1]] == 0) dfs(map, checked, x + 1, y, M, N)
}
