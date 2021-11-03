import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private lateinit var nums:IntArray
private lateinit var save:Array<IntArray>
fun main() {
	val br = BufferedReader(InputStreamReader(System.`in`))
	val bw = BufferedWriter(OutputStreamWriter(System.out))
	val N = br.readLine().toInt()
	val st = StringTokenizer(br.readLine())
	nums = IntArray(N + 1)
	for (i in 1..N) {
		nums[i] = st.nextToken().toInt()
	}
	val M = br.readLine().toInt()
	save = Array(N + 1) { IntArray(N + 1) }

	for (diff in 0 until N) {
		for (st in 1..N-diff) {
			val end = st + diff

			if (diff == 0) {
				save[st][end] = 1
				continue
			}
			if (diff == 1 && nums[st] == nums[end]) {
				save[st][end] = 1
				continue
			}
			if (nums[st] == nums[end] && save[st+1][end-1] == 1) save[st][end] = 1
		}
	}

	for (i in 0 until M) {
		val line = br.readLine().split(" ")
		val S = line[0].toInt()
		val E = line[1].toInt()
		bw.write(save[S][E].toString())
		bw.newLine()
	}
	bw.flush()
	bw.close()
}
