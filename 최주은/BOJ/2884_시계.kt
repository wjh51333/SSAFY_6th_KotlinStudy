import java.util.Scanner

fun main(args: Array<String>){
    val sc:Scanner = Scanner(System.`in`)
    val hour:Int = sc.nextInt()
    val min:Int = sc.nextInt()
    
    var rHour:Int = hour
    var rMin:Int = min - 45

    if(rMin < 0){
        rHour -= 1
        rMin = 60 + rMin
    }
    
    if(rHour < 0){
        rHour = 24 + rHour
    }
    
    print("$rHour $rMin")
}
