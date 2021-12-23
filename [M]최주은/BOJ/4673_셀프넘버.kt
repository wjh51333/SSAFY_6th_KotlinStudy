class `4673` {
}

val limit = 10001

fun main(args: Array<String>){
    var arr = BooleanArray(limit) { false } // 10001개의 배열을 false로 초기화 한다.

    for(i in 1 until limit){
        var idx:Int = check(i)

        if(idx < limit)
            arr[idx] = true
    }

    for(i in 1 until limit){
        if(!arr[i]) println(i)
    }
}

fun check(num:Int) : Int{
    var sum:Int = num
    var number = num;

    while(true){
        if(number == 0) break
        sum += number%10
        number /= 10
    }
    return sum
}
