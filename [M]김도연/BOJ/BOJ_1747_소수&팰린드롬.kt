import kotlin.math.sqrt

fun main() {
    var n = readLine()!!.toLong()

    while (true) {
        if (isPrime(n))
            if (isPalindrome(n.toString()))
                break
        n++
    }
    println(n)
}

fun isPrime(n: Long): Boolean {
    if (n == 1L) return false
    for (i in 2..sqrt(n.toDouble()).toLong())
        if (n % i == 0L)
            return false
    return true
}

fun isPalindrome(s: String): Boolean {
    for (i in 0..(s.length/2))
        if (s[i] != s[s.length-1 - i])
            return false
    return true
}