import java.util.*

fun main(ars: Array<String>) = with(Scanner(System.`in`)) {

    val num = nextLine().split(" ")
    print(num[0].toBigInteger() + num[1].toBigInteger())


}