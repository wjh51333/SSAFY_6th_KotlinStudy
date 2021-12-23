private const val MAX = 2000001
private val prime = BooleanArray(MAX) { it > 1 }

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    eratosthenes()
    for (num in n until MAX) {
        if (prime[num] && palindrome(num.toString())) {
            println(num)
            break
        }
    }
}

private fun eratosthenes() {
    for (i in 2 until MAX) {
        if (prime[i]) {
            for (j in i * 2 until MAX step i) {
                prime[j] = false
            }
        }
    }
}

private fun palindrome(num : String) : Boolean {
    val len = num.length - 1
    for (i in 0 until num.length / 2) {
        if (num[i] != num[len - i]) return false
    }
    return true
}