import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {

    var N = nextInt();
    var X = nextInt();
    var array = IntArray(N);

    for (i in 1..N) {
        var temp=nextInt()
        if(temp<X){print("$temp ")}
    }
}