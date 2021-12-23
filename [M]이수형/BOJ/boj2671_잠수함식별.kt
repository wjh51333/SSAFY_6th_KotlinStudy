fun main() = print(if (readLine()!!.matches("(100+1+|01)+".toRegex())) "SUBMARINE" else "NOISE")
