import java.util.*

fun main() {
	val maxHeap = PriorityQueue<Int> { o1, o2 ->
		if (o1 < o2) return@PriorityQueue 1;
		else return@PriorityQueue -1;
	}
	repeat(readLine()!!.toInt()) {
		val x = readLine()!!.toInt()
		if (x == 0) {
			if (maxHeap.isNotEmpty()) println(maxHeap.poll())
			else println(0)
		} else {
			maxHeap.add(x)
		}
	}
}
