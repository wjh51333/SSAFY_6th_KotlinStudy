
fun solution(s: String): Int {
    var answer = Integer.MAX_VALUE
    //예외인 케이스 한개만 들어오면 답은 1로 해줌
    if (s.length == 1) {
        answer = 1
    }

    //chunk를 사용하여여 Collenction을 나누어 지정 갯수로 잘라서 뽑아줌
   for (i in 1 until s.length) {
        val chunk = s.chunked(i)
        var st = ""
        var cnt = 1

        for (j in chunk.indices) {
            //마지막 chunk는 따로처리(범위비교 때문)
            if (j == chunk.size - 1) {
                if (chunk[j - 1] == chunk[j]) {
                    st += "$cnt${chunk[j]}"
                } else {
                    st += chunk[j]
                }
                break;
            }
            //계속 비교해나가며 다른게 나올때까지 cnt에 값 쌓아두고 다른게나오면 숫자를 적고 새로 문자열을만듬
            if (chunk[j] == chunk[j + 1]) {
                cnt++
            } else {
                if (cnt != 1) {
                    st += "$cnt${chunk[j]}"
                    cnt = 1
                } else {
                    st += chunk[j]
                }
            }
        }
       //전체 반복중 가장 작은것을 찾기위함
        answer = Integer.min(answer, st.length)
    }
    return answer
}
//
//fun main() {
//    println("${solution("aabbaccc")} 원래값 7")
//    println("${solution("ababcdcdababcdcd")} 원래값 9")
//    println("${solution("abcabcdede")} 원래값 8")
//    println("${solution("abcabcabcabcdededededede")} 원래값 14")
//    println("${solution("xababcdcdababcdcd")} 원래값 17")
//}
