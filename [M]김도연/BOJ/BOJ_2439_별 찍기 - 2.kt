import java.util.*

// for(int i = n ; i > 0 ; i--)를 표현하기 위해서는 for (i in n downTo 1)
// .. 은 증가만 가능하다.
fun main() {
    val sc:Scanner = Scanner(System.`in`)

    val n = sc.nextInt()

    for ( i in n downTo 1) {
        for ( j in 1 .. n) {
            if (i <= j)
                print("*")
            else
                print(" ")
        }
        println()
    }
}
