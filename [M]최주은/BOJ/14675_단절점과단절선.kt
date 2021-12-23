package boj.`14675_단절점과단절선`

fun main() {
    val N = readLine()!!.toInt()
    val leafNode = Array(N+1) {0}

    for (i in 1 until N){
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        leafNode[a]++
        leafNode[b]++
    }

    val Q = readLine()!!.toInt()
    for (i in 0 until Q){
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }

        if(a == 2) println("yes")
        else{
            if(leafNode[b] > 1) println("yes")
            else println("no")
        }
    }
}
