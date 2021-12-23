import java.util.Scanner

class `2447` {
}

fun main()=with(Scanner(System.`in`)) {
    print(factorial(nextInt()))
}

fun factorial(num:Int):Int{
    return if(num==0) 1 else if(num==1) 1 else num*(factorial(num-1))
}
