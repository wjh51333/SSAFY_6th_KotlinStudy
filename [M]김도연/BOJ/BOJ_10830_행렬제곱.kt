fun main() {
    val input = readLine()!!.split(" ")

    val N = input[0].toInt()
    val B = input[1].toLong()

    val A = Array(N) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }

    val result = square(A, B)

    for (i in result.indices) {
        for (j in result[i].indices) {
            print("${result[i][j] % 1000} ")
        }
        println()
    }
}

fun square(matrix: Array<IntArray>, n: Long): Array<IntArray> {
    if (n == 1L) {
        return matrix
    }

    return if (n % 2 != 0L) {
        calcMatrix(square(matrix, n - 1), matrix)
    } else {
        calcMatrix(square(matrix, n / 2))
    }
}

fun calcMatrix(matrix: Array<IntArray>): Array<IntArray> {
    return calcMatrix(matrix, matrix)
}

fun calcMatrix(matrixA: Array<IntArray>, matrixB: Array<IntArray>): Array<IntArray> {
    val result = Array(matrixA.size) { IntArray(matrixB.size) }

    for (i in result.indices) {
        for (j in result[i].indices) {
            result[i][j] = 0
            for (k in matrixA.indices) {
                result[i][j] = (result[i][j] + matrixA[i][k]*matrixB[k][j]) % 1000
            }
        }
    }

    return result
}

/*
반례

2 1
1000 1000
1000 1000

정답
0 0
0 0

오답
1000 1000
1000 1000

 */