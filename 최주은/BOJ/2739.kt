import java.util.Scanner

class boj {

}

fun main(args: Array<String>){
    val sc:Scanner = Scanner(System.`in`)
    val step:Int = sc.nextInt()

    for(i in 1..9){
        println("$step * $i = ${step*i}")
    }
}
