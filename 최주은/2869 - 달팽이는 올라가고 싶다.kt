import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class `11654` {
}

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val token = StringTokenizer(readLine(), " ")

    val A:Int = Integer.parseInt(token.nextToken())
    val B:Int = Integer.parseInt(token.nextToken())
    var V:Int = Integer.parseInt(token.nextToken())

    var result:Int = (V-B)/(A-B)
    if((V - B) % (A - B) != 0) result++;
    print(result)
}
