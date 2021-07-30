import java.util.*

class `10830` {
}

var MOD:Long = 1000L
var origin:Array<LongArray> = Array<LongArray>(0) { LongArray(0) }

fun main() = with(Scanner(System.`in`)) {

    val size:Int = nextInt()
    val exp:Long = nextLong()

    origin = Array<LongArray>(size) { LongArray(size) }

    for (i in 0 until size)
        for (j in 0 until size)
            origin[i][j] = nextLong() % MOD

    var result:Array<LongArray> = pow(origin,exp, size)

    result.forEach { it ->
        it.forEach { print("$it ") }
        println()
    }
}

fun pow(arr:Array<LongArray>, exp:Long, size:Int) : Array<LongArray>{

    if(exp == 1L)
        return arr

    var temp:Array<LongArray> = pow(arr,exp/2, size)

    temp = multiply(temp,temp, size)

    if((exp%2) == 1L)
        temp = multiply(temp, origin, size)

    return temp
}

fun multiply(a:Array<LongArray>, b:Array<LongArray>, size:Int) : Array<LongArray>{
    var temp:Array<LongArray> = Array<LongArray>(size) {LongArray(size)}

    for (i in 0 until size)
        for (j in 0 until size)
            for(k in 0 until size){
                temp[i][j] += a[i][k] * b[k][j]
                temp[i][j] %= MOD
            }

    return temp
}
