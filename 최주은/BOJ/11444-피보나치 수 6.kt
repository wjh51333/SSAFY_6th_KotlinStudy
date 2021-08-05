
var MOD_LONG:Long = 1000L
var original:Array<LongArray> = Array<LongArray>(0) { LongArray(0) }

fun main() = with(System.`in`.bufferedReader()) {
    var exp = readLine()!!.toLong()
    // fibo(num)

    original = Array<LongArray>(4) { LongArray(4) }

    // 초기화
    MOD_LONG = 1000000007L

    original[0][0] = 1
    original[0][1] = 1
    original[1][0] = 1
    original[1][1] = 0

    var result = pow2(original,exp-1,4)

    print(result[0][0])
}

fun fibo(num:Long){
    var arr = arrayOf(1, 0, 1)
    for (i in 1 until num)
    {
        arr[0] = arr[1]
        arr[1] = arr[2]
        arr[2] = (arr[0] + arr[1])%1000000007
    }

    print(arr[2])
}


fun pow2(arr:Array<LongArray>, exp:Long, size:Int) : Array<LongArray>{

    if(exp == 1L || exp == 0L)
        return arr

    var temp:Array<LongArray> = pow2(arr,exp/2, size)

    temp = multiply2(temp,temp, size)

    if((exp%2) == 1L)
        temp = multiply2(temp, original, size)

    return temp
}

fun multiply2(a:Array<LongArray>, b:Array<LongArray>, size:Int) : Array<LongArray>{
    var temp:Array<LongArray> = Array<LongArray>(size) {LongArray(size)}

    for (i in 0 until size)
        for (j in 0 until size)
            for(k in 0 until size){
                temp[i][j] += a[i][k] * b[k][j]
                temp[i][j] %= MOD_LONG
            }

    return temp
}
