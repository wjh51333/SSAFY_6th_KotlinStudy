import java.util.*

lateinit var inorder: Array<Int>
lateinit var postorder: Array<Int>
fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()
    inorder = Array(N) { nextInt() }
    postorder = Array(N) { nextInt() }
    preorder(0, N - 1, 0, N - 1)
}
// https://lotuslee.tistory.com/m/82 못하겠어서 이거참고했는데 어렵...
fun preorder(instart: Int, inend: Int, poststart: Int, posetend: Int) {
    if (instart <= inend && poststart <= posetend) {
        // 루트 노드출력
        print("${postorder[posetend]} ")

        var root = instart
        for (i in instart..inend) { // 인오더에서 루트 노드의 위치를 찾음
            if (inorder[i] == postorder[posetend]) {
                root = i;
                break;
            }
        }
        // 왼쪽 자식 트리
        preorder(instart, root - 1, poststart, poststart + root - instart - 1);
        // 오른쪽 자식 트리
        preorder(root + 1, inend, poststart + root - instart, posetend - 1);
    }
}
