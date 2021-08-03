class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        for (len in 1 until s.length) {
            answer = minOf(answer, compress(s, len))
        }
        return answer
    }

    // 문자열 압축
    fun compress(s : String, len : Int) : Int {
        var result = ""
        var now = s.substring(0, len)
        var cnt = 1

        for (i in len until s.length step len) {
            var end = i + len
            if (end > s.length)
                end = s.length

            val tmp = s.substring(i, end)
            if (tmp.equals(now)) { // 같으면 반복 횟수 증가
                cnt++
                continue;
            }

            // 같지 않으면 압축 결과 붙이고 다시 반복 체크
            if (cnt > 1) result += cnt.toString()
            result += now
            now = tmp
            cnt = 1
        }

        // 마지막에 남은 문자열을 붙여준다다
        if (cnt > 1) result += cnt.toString()
        result += now

        return result.length
    }
}