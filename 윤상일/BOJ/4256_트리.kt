fun main() {
	repeat(readLine()!!.toInt()) {
		val n = readLine()!!.toInt()
		val preorder = Array<Int>(n) {0}
		val inorder = Array<Int>(n) {0}
		for (i in 0 until n)
			preorder[i] = readLine()!!.toInt()
		for (i in 0 until n)
			inorder[i] = readLine()!!.toInt()

		// nx3 이차원 배열을 통해 트리 구조 표현. i행 0/1/2 => i 노드의 왼쪽자식/오른쪽자식/부모. 없을 경우 0.
		val tree = Array<Array<Int>>(n) { Array<Int>(3) {0} }
		makeTree(0, n - 1, preorder, inorder, tree)
	}
}

fun makeTree(leftBound:Int, RightBound:Int, preorder:Array<Int>, inorder:Array<Int>, tree:Array<Array<Int>>) {

}
