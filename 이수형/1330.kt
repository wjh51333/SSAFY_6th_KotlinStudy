import java.util.*

fun main(args:Array<String>)=with(Scanner(System.`in`)) {
    val num1 = nextInt()
    val num2 = nextInt()


    print(
        when{
            num1 < num2 -> "<"
            num1 == num2 -> "=="

            else -> ">"
        }
    )
}