package boj.`1806_부분합`

val input = readLine()!!.split(" ").map { it.toInt() }
val nums = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
val N = input[0]
val S = input[1]

fun main() {
    var low = 0
    var high = 0
    var sum = 0
    var result = Integer.MAX_VALUE

    while (true){
        if(sum >= S) {
            result = if(result > (high-low)) (high-low) else result
            sum -= nums[low++]
        }
        else if(high == N) break
        else sum += nums[high++]
    }

    if(result == Integer.MAX_VALUE) print(0)
    else print(result)
}
