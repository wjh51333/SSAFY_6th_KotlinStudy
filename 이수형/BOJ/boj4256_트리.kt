import java.util.*

lateinit var preorder: Array<Int>
lateinit var inorder: Array<Int>
fun main() = with(Scanner(System.`in`)) {

    for (i in 0 until readLine()!!.toInt()) {
        val N = nextInt()
        preorder = Array(N) { nextInt() }
        inorder = Array(N) { nextInt() }
        postorder(0, N, 0)
        println()
    }

}

fun postorder(start: Int, end: Int, root: Int) {
    for (i in start until end) {
        //전위순회의 root값을 inorder에서 찾으면 inorder에서 root-1은 왼쪽자식, root+1은 오른쪽자식
        //for loop을 다돌아서 마지막 노드에 왔을때 출력
        if (preorder[root] == inorder[i]) {
            postorder(start, i, root + 1)
            postorder(i + 1, end, root + 1 + i - start)
            print("${preorder[root]} ")
        }
    }
}