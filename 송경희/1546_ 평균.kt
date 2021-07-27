import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var a = arrayOfNulls<Double>(n)
    var input = br.readLine()!!.split(" ")
    var max  = 0.0
    var sum = 0.0

    for(i in 0..n-1) {
        a.set(i, input.get(i).toDouble())
        sum += a.get(i)!!
        if(a.get(i)!! > max)
            max = a.get(i)!!
    }
    var ave : Double = (((sum / n) * 100) / max)

    writer.write("$ave")
    writer.flush()
    writer.close()

}

