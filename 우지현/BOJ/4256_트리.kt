private val bw = System.out.bufferedWriter()
private var preorder = listOf<Int>()
private var inorder = listOf<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    val T = readLine().toInt()
    for (i in 1..T) {
        val n = readLine().toInt()
        preorder = readLine().trim().split(" ").map { it.toInt() }
        inorder = readLine().trim().split(" ").map { it.toInt() }
        postorder(0, 0, n)
        bw.newLine()
    }
    bw.flush()
}

private fun postorder(root : Int, start : Int, end : Int) {
    for (x in start until end) {
        if (inorder[x] == preorder[root]) {
            // 왼쪽 서브트리
            postorder(root + 1, start, x)
            // 오른쪽 서브트리
            postorder(root + x - start + 1, x + 1, end)
            bw.write("${preorder[root]} ")
        }
    }
}