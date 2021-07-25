import java.util.Scanner

fun main(args: Array<String>){
    val sc:Scanner = Scanner(System.`in`)
    val x:Int
    val y:Int

    while(sc.hasNextInt()){
        val x:Int = sc.nextInt()
        val y:Int = sc.nextInt()
        if(x==0 && y==0)
            break
        println(x+y)
    }
}
