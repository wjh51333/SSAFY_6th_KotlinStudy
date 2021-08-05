import java.util.*


// ex) (55, 150), (55, 155)의 경우 같은 등수
fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val arr = Array(n) { IntArray(2) }

    for (i in 0 until n) {
        arr[i][0] = sc.nextInt()
        arr[i][1] = sc.nextInt()
    }

    val ranks = IntArray(n){1}
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1])
                ranks[i]++
        }
    }

    for (i in 0 until n)
        print("${ranks[i]} ")
}
