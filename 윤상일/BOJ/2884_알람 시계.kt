fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    var h:Int = 0
    var m:Int = 0
    if (input.get(1) < 45) {
        if (input.get(0) == 0) h = 23 else h = input.get(0) - 1
        m = input.get(1) + 15
    } else {
        h = input.get(0)
        m = input.get(1) - 45
    }
    print("$h $m")
}