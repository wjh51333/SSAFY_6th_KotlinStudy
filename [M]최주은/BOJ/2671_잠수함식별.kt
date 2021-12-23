package boj.`2671_잠수함식별`
fun main() {
    if(readLine()!!.matches("(100+1+|01)+".toRegex())) print("SUBMARINE")
    else print("NOISE")
}
