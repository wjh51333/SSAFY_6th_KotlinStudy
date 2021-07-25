import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
	val br = BufferedReader(InputStreamReader(System.`in`))
	val init:Int = br.readLine().toInt()
	var comp:Int = init
	var trial:Int = 0
	while (true) {
		trial += 1
		comp = (comp / 10 + comp % 10) % 10 + (comp % 10) * 10
		if (init == comp) break
	}
	val bw = BufferedWriter(OutputStreamWriter(System.out))
	bw.write(trial.toString() + "\n")
	bw.flush()
	bw.close()
}
