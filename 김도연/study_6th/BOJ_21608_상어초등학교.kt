import kotlin.math.pow

fun main() {
    val N = readLine()!!.toInt()

    // N+2로 2차배열
    val classRoom = Array(N+2) {IntArray(N+2)}
    val students = Array(N*N) {IntArray(5)}

    for (i in 0 until N*N) {
        val st = readLine()!!.split(" ")

        for (j in 0 until 5)
            students[i][j] = Integer.parseInt(st[j])
    }

    // |r1 - r2| + |c1 - c2| => 상하좌우
    val dx = intArrayOf(0, 0, -1, 1)
    val dy = intArrayOf(-1, 1, 0, 0)

    for (stu in 0 until N*N) {
        val arr =  Array(N+2) {Array(N+2) { Pair(0 ,0) } }

        for (i in 1..N) {
            for (j in 1..N) {
                if (classRoom[i][j] == 0) {
                    var likeCount = 0
                    var emptyCount = 0
                    for (d in dx.indices) {
                        val di = i + dx[d]
                        val dj = j + dy[d]

                        if (di < 1 || di > N || dj < 1 || dj > N)
                            continue
                        if (students[stu].contains(classRoom[di][dj]))
                            likeCount++
                        else if (classRoom[di][dj] == 0)
                            emptyCount++
                    }
                    arr[i][j] = Pair(likeCount, emptyCount)
                }
            }
        }
        
        var pi = 1; var pj = 1
        while (classRoom[pi][pj] != 0) {
            if (pj < N)
                pj++
            else {
                pj = 1
                pi++
            }
        }

        var p = Pair(pi, pj)
        // 3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호, 열의 번호가 차례로 가장 작은 칸으로
        for (i in 1..N) {
            for (j in 1..N) {
                // 1. 비어있는 칸 중 인접한 칸에 좋아하는 학생들이 가장 많은 곳
                if (arr[i][j].first > arr[p.first][p.second].first) {
                    p = Pair(i, j)
                // 2. 1을 만족하는 칸이 여러개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로
                } else if (arr[i][j].first == arr[p.first][p.second].first) {
                    if (arr[i][j].second > arr[p.first][p.second].second) {
                        p = Pair(i, j)
                    }
                }
            }
        }

        classRoom[p.first][p.second] = students[stu][0]
    }

    var sum = 0
    for (i in 1..N) {
        for (j in 1..N) {
            val stIdx = findOrder(classRoom[i][j], students)
            var score = 0

            for (d in dx.indices) {
                val di = i + dx[d]
                val dj = j + dy[d]

                if (students[stIdx].contains(classRoom[di][dj]))
                    score++
            }

            if (score > 0)
                sum += (10.0).pow(score-1).toInt()
        }
    }

    println(sum)
}

fun findOrder(num :Int, arr :Array<IntArray>) :Int {
    for (i in arr.indices) {
        if (arr[i][0] == num)
            return i
    }
    return -1
}
