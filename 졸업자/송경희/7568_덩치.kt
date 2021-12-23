

fun main() {
    var n = readLine()!!.toInt()
    var array = Array<Array<Int>>(n){Array<Int>(2){i -> i+i} }

    for(i in 0..n-1) {
      var input = readLine()!!.split(" ")
        array[i][0] = input.get(0).toInt()
        array[i][1] = input.get(1).toInt()
    }

    for(i in 0..n-1) {
        var count = 0;
        for(j in 0..n-1) {
            if(j == i)
                continue
            if(array[i][0] < array[j][0] && array[i][1] < array[j][1])
                count++
        }
        print("${++count} ")
    }
}







