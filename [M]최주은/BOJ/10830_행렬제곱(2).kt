package boj.`10830_행렬제곱`

var N = 0

fun main() {
    val (n, B) = readLine()!!.split(" ").map { it.toLong() }
    N = n.toInt()

    var origin = Array(N.toInt()) { readLine()!!.split(" ").map { it.toLong() }.toTypedArray() }

    if (B == 1L){
        origin.forEach {
            it.forEach{ it2 ->
                print("${it2%1000L} ")
            }
            println()
        }
        return
    }

    origin = if (B % 2 == 0L){
        // 짝수인 경우
        dvd(origin, B)
    }else{
        // 홀수인 경우
        val arr = dvd(origin, B-1)
        com(arr, origin)
    }

    origin.forEach {
        it.forEach{ it2 ->
            print("${it2%1000L} ")
        }
        println()
    }
}

fun dvd(arr:Array<Array<Long>>, b:Long) : Array<Array<Long>> {
    if(b == 1L){
        return arr
    }

    var out = dvd(arr, b/2)
    out = com(out, out)

    if(b%2 == 1L) out = com(out, arr)

    return out
}

fun com(arr1:Array<Array<Long>>, arr2:Array<Array<Long>>) : Array<Array<Long>>{
    val out = Array(N) { Array(N) {0L} }

    for (i in 0 until N) {
        for (j in 0 until N) {
            var num = 0L
            for (k in 0 until N) {
                num += (arr1[i][k] * arr2[k][j]) % 1000L
            }
            out[i][j] = num
        }
    }

    return out
}
