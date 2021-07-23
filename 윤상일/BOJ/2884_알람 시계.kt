fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    var h:Int = 0
    var m:Int = 0
    if (input[1] < 45) {
        if (input[0] == 0) h = 23 else h = input[0] - 1
        m = input[1] + 15
    } else {
        h = input[0]
        m = input[1] - 45
    }
    print("$h $m")
}
