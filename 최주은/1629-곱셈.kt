import java.util.*

class `1629` {
}

var A:Long = 0
var B:Long = 0
var c:Long = 0

fun main() = with(Scanner(System.`in`)){
    A = nextLong()
    B = nextLong()
    c = nextLong()

    print(pow(A,B))
}

fun pow(a:Long, b:Long): Long {
    if(b.equals(1L))
        return a % c

    val temp:Long = pow(a, b/2)

    if((b % 2).equals(1L)) {
        return (temp * temp % c) * a % c
    }

    return temp * temp % c
}
