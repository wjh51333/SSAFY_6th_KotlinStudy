fun main() {
	var n = 0
	var m = 0
	var maxLen = 0
	readLine()!!.split(" ").let {
		n = it[0].toInt()
		m = it[1].toInt()
	}
	val map = Array(n) { Array(m) {0} }
	map.forEachIndexed { i, row ->
		val tmp = readLine()
		row.forEachIndexed { j, _ ->
			map[i][j] = tmp!![j].digitToInt()
		}
	}
	if (n > 1 && m > 1) {
		for (i in 1 until n) {
			for (j in 1 until m) {
				if (map[i][j] != 0) {
					map[i][j] = min(map[i - 1][j], map[i][j - 1], map[i - 1][j - 1]) + 1
				}
			}
		}
	}
	map.forEach { it.forEach { i -> maxLen = Math.max(maxLen, i) } }
	println(maxLen * maxLen)
}

fun min(a:Int, b:Int, c:Int):Int = if (a > b) { if (b > c) c else b	} else { if (a > c) c else a }
