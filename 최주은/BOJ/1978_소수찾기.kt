import java.util.Scanner;

class `9020` {
}

fun isPrime(num:Int):Boolean{
    if (num <= 1)
        return false;

    for (i in 2..num-2)
        if(num%i == 0) return false;

    return true;
}

fun main(args:Array<String>) = with(Scanner(System.`in`)) {

    val loopCount:Int = nextInt()
    var result:Int = 0
    var temp:Int

    for (i in 0 until loopCount){
        temp = nextInt()

        if(isPrime(temp))
            result++;
    }

    print(result);
}
