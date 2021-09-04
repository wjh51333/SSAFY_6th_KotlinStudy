fun main() {
    println(solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).toString())
    println(solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5))[1])
}

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = intArrayOf()
    var sum = 0
    var check = BooleanArray(speeds.size) { false }
    while (true) {
        var cnt = 0
        for (i in progresses.indices) {
            progresses[i] += speeds[i]
        }
        for (i in progresses.indices) {
            if (progresses[i] < 100) break
            if (!check[i] && progresses[i] >= 100) {
                cnt++
                sum++
                check[i] = true
            }
        }
        if (cnt > 0)
            answer = answer.plus(cnt)
        if (sum == speeds.size) break
    }

    return answer
}