import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

private val arr = Array<Int>(10001) { i -> i }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
	repeat(readLine().toInt()) {
		val n:Int = readLine().toInt()
		if (n == 4) println("2 2")
		else if (n == 6) println("3 3")
		else {
			for (i in n / 2 - 1 downTo 2 step 2) {
				if ()
			}
		}
	}
}

fun isPrime(n:Int):Boolean {
	if (arr[n] == 0) return false
	for (i in 2..sqrt(n.toDouble()).toInt()) {
		if (arr[i] == 0) continue
		for (j in i+i..n step 2) {
			arr[j] = 0
		}
	}
	if (arr[n] == 0) return false
	return true
}
