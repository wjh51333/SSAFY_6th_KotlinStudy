import kotlin.math.abs

private var INF = 2500
private var map = arrayOf<List<Int>>()
private var home = mutableListOf<Pair<Int, Int>>()
private var chicken = mutableListOf<Pair<Int, Int>>()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    map = Array(n) { readLine().split(" ").map { it.toInt() } }

    for (i in map.indices) {
        for (j in map[i].indices) {
            if (map[i][j] == 1) home.add(Pair(i, j)) // 집
            else if (map[i][j] == 2) chicken.add(Pair(i, j)) // 치킨집
        }
    }
    println(choose(mutableListOf(), m, 0))
}

private fun choose(arr : MutableList<Pair<Int, Int>>, m : Int, now : Int) : Int {
    if (now >= chicken.size) {
        var result = INF
        if (arr.isNotEmpty() && arr.size <= m) // m개 이하의 치킨집을 고른 경우
            result = distance(arr)
        return result
    }

    var ret = INF // 가장 작은 도시의 치킨 거리
    arr.add(chicken[now])
    ret = minOf(ret, choose(arr, m, now + 1)) // 선택
    arr.removeLast()
    ret = minOf(ret, choose(arr, m, now + 1)) // 선택 X
    return ret
}

private fun distance(arr: MutableList<Pair<Int, Int>>) : Int {
    var result = 0 // 도시의 치킨 거리
    for (i in home.indices) {
        var dist = INF
        for (j in arr.indices) {
            val tmp = abs(arr[j].first - home[i].first) + abs(arr[j].second - home[i].second)
            dist = minOf(dist, tmp) // 집과 가장 가까운 치킨집과의 거리
        }
        result += dist
    }
    return result
}