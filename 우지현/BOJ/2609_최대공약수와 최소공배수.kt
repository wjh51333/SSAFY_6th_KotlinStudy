fun gcd(a : Int, b : Int) : Int = if (b == 0) a else gcd(b, a % b)
fun lcm(a : Int, b : Int) = a * b / gcd(a, b)

fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    println("${ gcd(input[0], input[1]) }\n${lcm(input[0], input[1]) }")
}