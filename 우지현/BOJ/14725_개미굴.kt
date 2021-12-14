private class Tunnel {
    private val child = mutableMapOf<String, Tunnel>()

    fun insert(food : List<String>, idx : Int) {
        if (idx == food.size) return

        if (!child.containsKey(food[idx])) // food[idx]가 없으면
            child[food[idx]] = Tunnel() // 추가
        child[food[idx]]?.insert(food, idx + 1) // 그 다음 먹이 추가
    }

    fun print(depth : Int) {
        child.toSortedMap().forEach { (t, u) ->
            for (i in 0 until depth) {
                print("--")
            }
            println(t)
            u.print(depth + 1)
        }
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val root = Tunnel()

    for (i in 0 until n) {
        val food = readLine().split(" ").filterIndexed { index, s -> index > 0 }
        root.insert(food, 0)
    }
    root.print(0)
}