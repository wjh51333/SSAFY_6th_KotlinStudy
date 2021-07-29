import java.util.*

fun main() {
    var T = readLine()!!.toInt()
    while (T-- != 0) {
        val cmd = readLine()!!
        val n = readLine()!!.toInt()
        val arr = readLine()!!.split("[", ",", "]")
            .map { if (it.isBlank()) null else it.toInt() }.filterNotNull()
        println(getResult(cmd, arr))
    }
}

fun getResult(cmd : String, arr : List<Int>) : String {
    var dq = ArrayDeque<Int>()
    if (arr.isNotEmpty()) dq.addAll(arr.toMutableList())

    var cnt = 0
    for (x in cmd) {
        if (x == 'R') cnt++
        else {
            if (dq.isEmpty()) return "error"
            if (cnt % 2 == 0) dq.remove()
            else  dq.removeLast()
        }
    }
    if (cnt % 2 == 0) return dq.joinToString(",", "[", "]")
    return dq.reversed().joinToString(",", "[", "]")
}