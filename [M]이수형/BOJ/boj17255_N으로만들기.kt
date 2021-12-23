package today3

val set = HashSet<String>()
var num = 0
val list = ArrayList<Int>()
var temp = ""
fun main() {
    temp = readLine()!!
    num = temp.length
    temp.forEach { if (!list.contains(it - '0')) list.add(it - '0') }
    back(0, "", "")
    print(set.size)
}

fun back(depth: Int, make: String, howtomake: String) {
    if (depth == num) {
        if (make == temp) set.add(howtomake)
        return
    }
    for (i in list) {
        back(depth + 1, make + i.toString(), howtomake + make + i)
        back(depth + 1, i.toString() + make, howtomake + make + i)
    }
}