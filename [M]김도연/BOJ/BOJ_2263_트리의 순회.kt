import java.util.*

private lateinit var inO: Array<Int>
private lateinit var postO: Array<Int>
private lateinit var position: Array<Int>
private val sb = StringBuffer()

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    inO = Array(n) {sc.nextInt()}
    postO = Array(n) {sc.nextInt()}
    position = Array(n+1) {0}
    for (i in 0 until n)
        position[inO[i]] = i

    orderPre(0, n-1, 0, n-1)
    println(sb.toString())
}

fun orderPre(inStart: Int, inEnd: Int, postStart: Int, postEnd: Int) {
    if (inStart > inEnd || postStart > postEnd)
        return

    val root = postO[postEnd]
    sb.append("$root ")

    orderPre(inStart, position[root]-1, postStart, postStart + (position[root] - inStart) - 1)
    orderPre(position[root]+1, inEnd, postStart + (position[root] - inStart),postEnd-1)
}