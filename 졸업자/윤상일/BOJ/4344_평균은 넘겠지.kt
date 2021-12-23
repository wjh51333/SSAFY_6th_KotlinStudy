import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
	val br = BufferedReader(InputStreamReader(System.`in`))
	val bw = BufferedWriter(OutputStreamWriter(System.out))
	repeat(br.readLine().toInt()) {
		val token = StringTokenizer(br.readLine())
		var personnel:Int = token.nextToken().toInt()
		val scores = Array<Int>(personnel) {0}
		var sum:Int = 0
		var count:Int = 0

		for (i in 0 until personnel) {
			scores[i] = token.nextToken().toInt()
			sum += scores[i]
		}
		val mean = sum.toDouble() / personnel.toDouble()
		for (i in 0 until personnel) {
			if (scores[i] > mean) count++
		}
		val ratio = String.format("%.3f", (count.toDouble() / personnel.toDouble()) * 100)
		bw.write("$ratio%\n")
	}
	bw.flush()
	bw.close()
}
