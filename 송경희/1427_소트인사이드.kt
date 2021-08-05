import java.util.*

fun main() {
    var n = readLine()
    var arr = n!!.toCharArray()

    Arrays.sort(arr)
    for(i in arr.size-1 downTo 0)
        print(arr[i])
}







