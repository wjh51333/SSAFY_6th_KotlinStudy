class 문자열압축 {
}

fun main() {
    var s = Solution()
    var t = "aabbaccc"

    print(s.solution(t))
}

class Solution {
    fun solution(s: String): Int {
        var answer = 0

        for (i in 1 until (s.length/2)){
            // i 는 자르려는 문자열 크기
            var len = 0
            var count = 1
            var pre = s.slice(0 until i)

            for (j in i until s.length step i){
                var cur = s.slice(j until j+i)
                if(cur == pre)
                    count++
                else{
                    if(count > 1)
                        len += count.toString().length
                    len += pre.length
                    pre = cur
                    count = 1
                }

                if(j == s.length-1){
                    if(count > 1)
                        len += count.toString().length
                    len += pre.length
                    pre = cur
                    count = 1
                }
            }

            if(answer < len)
                answer = len
        }
        return answer
    }
}
