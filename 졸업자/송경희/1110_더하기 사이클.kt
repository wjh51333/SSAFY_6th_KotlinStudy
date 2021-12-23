import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var new = n
    var count = 0

    do{
        n = n % 10 * 10 + (n / 10 + n % 10) % 10
        count++
    } while (new != n)

    writer.write(count.toString())
    writer.flush()
    writer.close()

}

