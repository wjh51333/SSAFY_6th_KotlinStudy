fun main() = with(System.`in`.bufferedReader()) {
    val set = mutableSetOf<String>()
    val n = readLine().toInt()

    for (x in 1..n) {
        val (name, status) = readLine().split(" ")
        if (status.equals("enter"))
            set.add(name)
        else
            set.remove(name)
    }
    set.sortedDescending().forEach { println(it) }
}