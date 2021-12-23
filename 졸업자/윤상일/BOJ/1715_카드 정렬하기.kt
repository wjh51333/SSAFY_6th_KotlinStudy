import java.util.*

fun main() {
	val N = readLine()!!.toInt()
	val cards = PriorityQueue<Int>(N)
	if (N == 1) {
		println(0)
		return
	}
	repeat(N) {
		cards.add(readLine()!!.toInt())
	}
	var sum = 0
	while (true) {
		var cardSum = 0
		cardSum = cards.poll() + cards.poll()
		sum += cardSum
		if (cards.isEmpty()) break
		cards.add(cardSum)
	}
	println(sum)
}
