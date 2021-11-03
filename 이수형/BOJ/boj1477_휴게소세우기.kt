package today3

import java.util.*

private var N = 0
private var M = 0
private var L = 0

private data class Load(val distance: Double, val num: Int)

fun main() = with(Scanner(System.`in`)) {

    //처음에는 사이를 나누기 2를 반복했으나 예외가 생기는경우가 있음
    //cnt를 도입하여 사이를 몇번 나누는지 계속 저장하여 업데이트
    val pq: PriorityQueue<Load> = PriorityQueue(compareBy<Load> { it.distance }.reversed())
    val list = ArrayList<Int>()
    N = nextInt()
    M = nextInt()
    L = nextInt()
    for (i in 0 until N) {
        list.add(nextInt())
    }
    list.add(0)
    list.add(L)
    list.sort()
    //println(list)
    for (i in 0 until list.size - 1) {
        pq.add(Load((list[i + 1] - list[i]).toDouble(), 1))
    }
    for (i in 0 until M) {
        // println(pq)
        var temp = pq.poll()
        pq.add(Load(((temp.distance * temp.num) / (temp.num + 1)), temp.num + 1))
    }
    var result = pq.first().distance
    print(if (result == result.toInt().toDouble()) result.toInt() else result.toInt() + 1)
}