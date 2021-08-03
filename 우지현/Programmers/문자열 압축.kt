class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        for (len in 1 until s.length) {
            answer = minOf(answer, compress(s, len))
        }
        return answer
    }

    fun compress(s : String, len : Int) : Int {
        var result = ""
        var now = s.substring(0, len)
        var cnt = 1

        for (i in len until s.length step len) {
            var end = i + len
            if (end > s.length)
                end = s.length

            val tmp = s.substring(i, end)
            if (tmp.equals(now)) {
                cnt++
                continue;
            }

            if (cnt > 1) result += cnt.toString()
            result += now
            now = tmp
            cnt = 1
        }

        if (cnt > 1) result += cnt.toString()
        result += now

        return result.length
    }
}