fun main() {
    var checks = BooleanArray(10001)

    for (i in 1..10000) {
        val n = d(i)

        if (n < 10001) {
            checks[n] = true
        }
    }

    for (i in 1..10000) {
        if ( !checks[i] )
            println(i)
    }
}

fun d(n:Int):Int {
    var tmp = n
    var sum = tmp

    while (tmp > 0) {
        sum += (tmp % 10)
        tmp /= 10
    }
    return sum
}
