fun main() {
    val (n, r) = readLine()!!.split(" ").map{it.toInt()}
    val arr = Array<Int>(n) {i -> i+1}
    var output = arrayOfNulls<Int>(n)
    var visited = arrayOfNulls<Boolean>(n)

    perm(arr, output, visited, 0, n, r)


}
fun perm(arr: Array<Int>, output: Array<Int?>, visited: Array<Boolean?>, depth: Int, n: Int, r: Int ) {
    if(depth == r) {
        for(i in 0..r-1)
            print("${output[i]} ")
        println()
        return
    }
    for(i in 0..n-1){
        if(visited[i] != true) {
            visited[i] = true
            output[depth] = arr[i]
            perm(arr, output, visited, depth + 1, n, r)
            visited[i] = false
        }
    }


}














