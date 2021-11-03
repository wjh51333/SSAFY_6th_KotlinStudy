fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    val T = readLine().toInt()
    val mp = mutableMapOf<Int, Int>()

    for (t in 1..T) {
        val n = readLine().toInt()

        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        for (i in 1..n) {
            val input = readLine().split(" ")
            val num = input[1].toInt()
            when (input[0]) {
                "I" -> {
                    if (mp.contains(num)) mp[num] = mp[num]!! + 1
                    else {
                        mp[num] = 1
                        max = maxOf(max, num)
                        min = minOf(min, num)
                    }
                }
                "D" -> {
                    if (mp.isEmpty()) continue
                    
                    if (num == 1) { // 최댓값 제거
                        if (mp[max] == 1) {
                            mp.remove(max)
                            max = if (mp.isEmpty()) Int.MIN_VALUE else mp.maxOf { it.key }
                            if (mp.isEmpty()) min = Int.MAX_VALUE
                        }
                        else
                            mp[max] = mp[max]!! - 1
                    } else { // 최솟값 제거
                        if (mp[min] == 1) {
                            mp.remove(min)
                            min = if (mp.isEmpty()) Int.MAX_VALUE else mp.minOf { it.key }
                            if (mp.isEmpty()) max = Int.MIN_VALUE
                        }
                        else
                            mp[min] = mp[min]!! - 1
                    }
                }
            }
        }

        if (mp.isEmpty())
            bw.write("EMPTY\n")
        else {
            bw.write("$max $min\n")
            mp.clear()
        }
    }
    bw.flush()
}