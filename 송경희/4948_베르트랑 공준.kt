import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt

fun main() {
    var br = BufferedReader(InputStreamReader(System.`in`))

    while(true){
        var sum = 0
        var flag = true
        var n = br.readLine().toInt()
        if(n == 0) break
     for(i in n+1..(2*n)) {
            if(i == 2) {
                flag = false
                sum++
            }
         var r = sqrt(i.toDouble()) + 1
            for(j in 2..(r.toInt()-1)) {
                if(i % j == 0) {
                    flag = false
                    break
                }
            }
         if(flag)
             sum++

         flag = true
        }

        println(sum)
    }
}






