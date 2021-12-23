package today3

import kotlin.math.min
//https://steady-coding.tistory.com/14
data class Cube(val A: Int, val B: Int)
fun main() = with(System.`in`.bufferedReader()) {

    //Long으로 안받아서 계속 틀림 ;;;
    val (length, width, height) = readLine().split(" ").map { it.toLong() }
    val N = readLine().toInt()
    val cubeList = ArrayList<Cube>()
    repeat(N) {
        val temp = readLine().split(" ").map { it.toInt() }
        cubeList.add(Cube(1 shl temp[0], temp[1]))
    }

    var save = 0L
    var total = 0L
    for (i in N - 1 downTo 0) {
        //다음 시행이 될때는 부피단위가 이전의 8배가 되므로 2x2x2 -> 1x1x1로 갈때 한개의 2x2x2큐브는 8개의 1x1x1이됨
        save *= 8
        //큰거부터 넣어주는 작업 자르고 넣을수 있는 만큼 넣음
        var cntcube = min((length shr i) * (width shr i) * (height shr i) - save, cubeList[i].B.toLong())
        save += cntcube
        total += cntcube

    }
    println(if (save == length * width * height) total else "-1")

}

