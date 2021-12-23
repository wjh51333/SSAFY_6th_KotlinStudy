import kotlin.math.min

private lateinit var visited:BooleanArray
private lateinit var jumpList:Array<IntArray>
private var N = 0
private var K = 0
private var Kused = false
private var answer = 10000000
fun main() {
	N = readLine()!!.toInt()
	visited = BooleanArray(N)
	jumpList = Array(N) { IntArray(2) }
	for (i in 1 until N) {
		readLine()!!.split(" ").map { it.toInt() }.let {
			jumpList[i][0] = it[0]
			jumpList[i][1] = it[1]
		}
	}
	K = readLine()!!.toInt()
	dp(0, 1)
	println(answer)
}

private fun dp(energy:Int, loc:Int) {
	if (loc == N) {
		answer = min(answer, energy)
	} else if (energy >= answer) {
		return
	} else {
		visited[loc] = true
		dp(energy + jumpList[loc][0], loc + 1)
		visited[loc] = false

		if (N - loc >= 2) {
			visited[loc] = true
			dp(energy + jumpList[loc][1], loc + 2)
			visited[loc] = false
		}

		if (N - loc >= 3 && !Kused) {
			visited[loc] = true
			Kused = true
			dp(energy + K, loc + 3)
			visited[loc] = false
			Kused = false
		}
	}
}
