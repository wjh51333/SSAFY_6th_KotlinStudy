

fun main() {
    var input = readLine()!!.toInt()
    println(cal(input))
}
fun cal(input : Int) : Int{
    if(input == 0)
        return 1
    else if(input == 1)
        return input
    else
    return input * cal(input-1)

}






