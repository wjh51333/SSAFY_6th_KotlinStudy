import java.util.*

fun main() {
	var N:Int = 0
	var K:Int = 0
	readLine()!!.split(" ").let {
		N = it[0].toInt()
		K = it[1].toInt()
	}
	val a = readLine()!!.split(" ").map { it.toInt() }
	var maxLen = 0
	var length = 0
	var start = 0
	var end = 0
	val checked = Array(101010) {LinkedList<Int>()}
	while (end != N) {
		if (checked[a[end]].size < K) {
			checked[a[end]].add(end)
			length++
			end++
		} else {
			val new = checked[a[end]].poll() + 1
			if (new > start) {
				length -= (new - start)
				start = new
			}
		}
		maxLen = maxLen.coerceAtLeast(length)
	}
	println(maxLen)
}
