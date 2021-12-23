lateinit var list: Array<ArrayList<Int>>
lateinit var check: Array<Boolean>
var result = false
fun main() {
    var temp = readLine()!!.split(" ")
    val N = temp[0].toInt()
    val M = temp[1].toInt()
    list = Array(N) { ArrayList<Int>() }
    check = Array(N) { false }
    repeat(M) {
        temp = readLine()!!.split(" ")
        val num1 = temp[0].toInt()
        val num2 = temp[1].toInt()
        list[num1].add(num2)
        list[num2].add(num1)
    }
    for (i in list.indices) if (result) break else dfs(i, 0)
    print(if (result) "1" else "0")
}

fun dfs(start: Int, cnt: Int) {
    if (cnt == 4) {
        result = true
        return
    }
    check[start] = true
    for (i in list[start]) if (!check[i]) dfs(i, cnt + 1)
    check[start] = false
}