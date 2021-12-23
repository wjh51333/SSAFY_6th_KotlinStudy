import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var nextCheck = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
	repeat(readLine().toInt()) {
		nextCheck = 0
		val n = readLine().toInt()
		val preorder = IntArray(n)
		val inorder = IntArray(n)
		var st = StringTokenizer(readLine())
		for (i in 0 until n)
			preorder[i] = st.nextToken().toInt()
		st = StringTokenizer(readLine())
		for (i in 0 until n)
			inorder[i] = st.nextToken().toInt()

		postorderPrint(0, n - 1, preorder, inorder)
		println()
	}
}

fun postorderPrint(leftBound:Int, rightBound:Int, preorder:IntArray, inorder:IntArray) {
	val point = inorder.indexOf(preorder[nextCheck])
	nextCheck++
	if (point > leftBound) postorderPrint(leftBound, point - 1, preorder, inorder)
	if (point < rightBound) postorderPrint(point + 1, rightBound, preorder, inorder)
	print(inorder[point].toString() + " ")
}
