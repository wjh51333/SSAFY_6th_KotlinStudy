fun main() {
    val (a, b) = readLine()!!.split(" ").map{it.toInt()}

    if( b >= 45) {
        println("$a ${b-45}")
    }
    else {
        if(a == 0)
            println("23 ${15+b}")
        else
            println("${a-1} ${15+b}")
    }
}