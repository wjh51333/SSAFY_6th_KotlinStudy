private var n = 0
private lateinit var inorder : List<Int>
private lateinit var postorder : List<Int>
private val idx = mutableMapOf<Int, Int>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    inorder = readLine().split(" ").map { it.toInt() }
    postorder = readLine().split(" ").map { it.toInt() }
    inorder.forEachIndexed { index, i -> idx[i] = index }
    preorder(0, n - 1, 0, n - 1)
}

private fun preorder(inLeft : Int, inRight : Int, postLeft : Int, postRight : Int) {
    // 범위를 벗어난 경우
    if (inLeft > inRight || postLeft > postRight) return;
    
    val rootIdx = idx[postorder[postRight]]!! // inorder에서 root의 위치
    val left = rootIdx - inLeft // 왼쪽 서브트리 노드 개수
    print("${postorder[postRight]} ")
    
    // 왼쪽
    preorder(inLeft, rootIdx - 1, postLeft, postLeft + left - 1)
    
    // 오른쪽
    preorder(rootIdx + 1, inRight, postLeft + left, postRight - 1)
}