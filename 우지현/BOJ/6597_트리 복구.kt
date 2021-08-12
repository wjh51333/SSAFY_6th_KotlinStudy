private var preorder = ""
private var inorder = ""

fun main() = with(System.`in`.bufferedReader()) {
    var r = readLine()
    while (!r.isNullOrEmpty()) {
        val (pre, ino) = r.split(" ")
        preorder = pre
        inorder = ino
        postorder(0, 0, preorder.length)
        println()
        r = readLine()
    }
}

private fun postorder(root : Int, start : Int, end : Int) {
    for (i in start until end) {
        if (inorder[i] == preorder[root]) {
            // 왼쪽 서브트리
            postorder(root + 1, start, i)
            // 오른쪽 서브트리
            postorder(root + i - start + 1, i + 1, end)
            print(preorder[root])
        }
    }
}



