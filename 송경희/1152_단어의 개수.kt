import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine()
    var s = n.trim()
    var size = 0
    var  list = s.split(" ")
    if(list.get(0).isBlank())
        size = 0
    else
        size = list.size
    
    writer.write("$size")

    writer.flush()
    writer.close()

}




