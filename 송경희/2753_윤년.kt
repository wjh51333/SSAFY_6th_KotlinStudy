fun main(args: Array<String>) {

    var sc: String? = readLine()
    var input: String = sc.toString()

    var value:Int = input.toInt();

    if((value % 4 == 0 && value % 100 != 0) || value % 400 == 0) {
        println("1")
    }
    else {
        println("0")
    }

}