package boj.`4256_트리`

lateinit var preorder:Array<Int>
lateinit var inorder:Array<Int>

fun main() = with(System.`in`.bufferedReader()){
    val t = readLine().toInt()
    var tc = 0

    while(tc++ < t){
        val n = readLine().toInt()

        // 입력
        preorder = readLine().trim().split(" ").map { it.toInt() }.toTypedArray()
        inorder = readLine().trim().split(" ").map { it.toInt() }.toTypedArray()

        // 진행
        procedure(0, n,  0)
        println()
    }
}

fun procedure(s: Int, e:Int, pos:Int) {
    for (i in s until e){
        if(preorder[pos] == inorder[i]){
            procedure(s, i, pos+1)
            procedure(i+1, e, pos+i-s+1)
            print("${inorder[i]} ")
        }
    }
}
