import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val bw = BufferedWriter(OutputStreamWriter(System.out))

fun rec(n: Int, i:Int, j:Int) {
	if ((i/n)%3 == 1 && (j/n)%3 == 1) {
		bw.write(" ")
	} else {
		if (n/3 == 0) {
			bw.write("*")
		}
		else
			rec(n/3,i,j)
	}
}

fun main() {
	val br = BufferedReader(InputStreamReader(System.`in`))
	val len = br.readLine().toInt()
	for (i in 0 until len) {
		for (j in 0 until len)
			rec(len, i, j)
		bw.newLine()
	}
	bw.flush()
	bw.close()
}
