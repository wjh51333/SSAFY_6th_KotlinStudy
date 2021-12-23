private var n:Int = 0
private lateinit var inorder:IntArray
private lateinit var postorder:IntArray
private lateinit var indexInInorder:IntArray
fun main() {
	n = readLine()!!.toInt()
	inorder = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	postorder = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
	indexInInorder = IntArray(n + 1)
	inorder.forEachIndexed { index, i -> indexInInorder[i] = index }

	logic(0, n-1, 0, n-1)
}

private fun logic(il:Int, ir:Int, pl:Int, pr:Int) {
	if (il>ir || pl>pr) return
	val root = postorder[pr]
	print("$root ")
	val rootIndexInInOrder = indexInInorder[root]
	val left = rootIndexInInOrder - il
	logic(il, rootIndexInInOrder, pl, pl + left - 1)
	logic(rootIndexInInOrder + 1, ir, pl + left, pr - 1)
}
