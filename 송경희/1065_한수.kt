import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    var count = 0

    if(n < 100)
        writer.write("$n")
    else{
        for(i in 100..n)
            if(num(i.toString()))
                count++
        writer.write("${count+99}")
    }



    writer.flush()
    writer.close()

}

fun num(x: String) :Boolean {
    var a = arrayOfNulls<Int>(3)
    var flag = false
    a.set(0, x[0].toInt())
    a.set(1, x[1].toInt())
    a.set(2, x[2].toInt())
    if(a.get(1)!! - a.get(0)!! == a.get(2)!! - a.get(1)!!)
         flag = true
    return flag
}


