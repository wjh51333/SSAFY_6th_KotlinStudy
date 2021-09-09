// m을  2부터 시작하여 숫자를 키우면 저절로 소수만으로 나누게 된다.
// 1은 소수가 아니라 출력하면 안된다.

fun main() {

    var n = readLine()!!.toInt()

    var sb = StringBuffer()

    var m = 2
    while (n > 1) {
        if (n % m == 0) {
            n /= m
            sb.append(m).append("\n")
        } else {
            m++
        }
    }
    print(sb)
}
