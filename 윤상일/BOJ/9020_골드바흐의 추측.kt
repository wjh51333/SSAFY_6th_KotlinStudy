private val arr = Array<Int>(10001) { i -> i }

fun main() {
	fun isPrime(n: Int): Boolean = (arr[n] != 0)
	// 소수 구하는 효율적 알고리즘 : https://marobiana.tistory.com/91 참조
	for (i in 2..100) {
		if (arr[i] == 0) continue
		for (j in i + i..10000 step i) {
			arr[j] = 0
		}
	}
	repeat(readLine()!!.toInt()) {
		val n: Int = readLine()!!.toInt()
		for (i in n / 2 downTo 2) {
			if (isPrime(i) && isPrime(n - i)) {
				println("$i ${n - i}")
				break
			}
		}
	}
}
