fun main() {
    val n = readLine()!!.toInt()

    val arr = IntArray(n) {readLine()!!.toInt()}

    // 버블 정렬
    for (i in n-1 downTo 0) {
        for (j in 0 until i) {
            if (arr[j] > arr[j+1]) {
                swap(arr, j,j+1)
            }
        }
    }

    // 삽입 정렬
//    for (i in 1 until n) {
//        var key = arr[i]
//        for (j in i-1 downTo 0) {
//            if (arr[j] > key) {
//                swap(arr, j+1, j)
//            }
//        }
//    }

    // 카운팅 정렬 (실패, ArrayIndexOutOfBounds)
//    val k = arr.maxOrNull()
//    val count = IntArray(k!! + 1)
//    for (i in 0 until n) {
//        count[arr[i]]++
//    }
//    for (i in 0 until k) {
//        count[i+1] += count[i]
//    }
//    val sorted_arr = IntArray(n)
//    for (i in n-1 downTo 0) {
//        val num = arr[i]
//        sorted_arr[count[num]] = arr[i]
//        count[num]--
//    }
//    for (i in 0 until n)
//        println(sorted_arr[i])

    for (i in 0 until n)
        println(arr[i])
}

fun swap(arr :IntArray, i :Int, j :Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}
