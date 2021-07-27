import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val N = nextInt();
    val sb = StringBuilder()
    val input = IntArray(N) { nextInt() }
    val arr = input.sortedArray()
    val temp = mutableMapOf<Int, Int>()
    var cnt = 0;
    for (i in 0 until N - 1) {
        if (arr[i] != arr[i + 1]) {
            temp[arr[i]] = cnt++
        }
    }
    temp[arr[N - 1]] = cnt

    for (i in 0 until N) {
        print(temp[input[i]])
        print(" ")
    }
}
