import java.util.Scanner

fun main(args: Array<String>){
    val sc:Scanner = Scanner(System.`in`)
    val count = sc.nextInt()
    var large:Int = -1000001
    var small:Int = 1000001

    for(i in 0 until count){
        val num:Int = sc.nextInt()
        if (num > large)
            large = num

        if(num < small)
            small = num

    }

    print("$small $large")
}
