

fun main() {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    var x = 0
    if(b >= c)
        x = -1
    else
        x = a / (c - b) + 1



    println(x)
}







