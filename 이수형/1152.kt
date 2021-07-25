import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var cnt = 0
    nextLine().split(" ").forEach { if (it.isNotBlank()) cnt++ }
    print(cnt)
}

