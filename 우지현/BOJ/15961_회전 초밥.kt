fun main() = with(System.`in`.bufferedReader()) {
    val (n, d, k, c) = readLine().split(" ").map { it.toInt() }
    val sushi = MutableList<Int>(n) { readLine().toInt() }
    sushi.addAll(sushi) // 원형이므로 똑같은 원소 추가

    var answer = 0
    var cnt = 0
    var mp = mutableMapOf<Int, Int>()

    var left = 0
    var right = 0
    while (right < 2 * n) {
        if (cnt < k) { // 연속해서 먹은 접시가 k개보다 적을 경우
            // 초밥 추가
            val num = sushi[right]
            mp[num] = mp[num]?.plus(1) ?: 1
            cnt++
            right++
        } else { // 연속해서 먹은 접시가 k개인 경우
            // 초밥 가짓수의 최댓값 갱신
            answer = maxOf(answer, if (mp.containsKey(c)) mp.size else mp.size + 1)

            // 첫번째 초밥 제거
            val num = sushi[left]
            mp[num] = mp[num]!!.minus(1)
            if (mp[num] == 0)
                mp.remove(num)
            cnt--
            left++
        }
    }
    println(answer)
}