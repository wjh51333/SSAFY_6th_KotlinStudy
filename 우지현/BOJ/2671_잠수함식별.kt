fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    println(if (!s.matches("((100+1+)|(01))+".toRegex())) "NOISE" else "SUBMARINE")
}