import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val len = Integer.parseInt(br.readLine())

    for(i in 1..len) {
        val input = br.readLine()
        val st = StringTokenizer(input, " ")
        val a = Integer.parseInt(st.nextToken())
        val b = Integer.parseInt(st.nextToken())
        println(a+b)
    }
}