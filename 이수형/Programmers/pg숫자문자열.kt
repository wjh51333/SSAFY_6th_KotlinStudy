fun main() {
    print(solution("one4seveneight"))
    print(solution2("one4seveneight"))
}


//when 으로 바꾸고 넘어가는 고전
fun solution(s: String): Int {
    var answer: String = ""
    var st = s.toCharArray()
    var i = 0
    while (i < st.size) {
        when (st[i]) {
            'z' -> {
                answer += 0
                i += 4
            }
            'o' -> {
                answer += 1
                i += 3
            }
            't' -> {
                if (s[i + 1] == 'w') {
                    answer += 2
                    i += 3
                } else {
                    answer += 3
                    i += 5
                }
            }
            'f' -> {
                if (s[i + 1] == 'o') answer += 4 else answer += 5
                i += 4
            }
            's' -> {
                if (s[i + 1] == 'i') {
                    answer += 6
                    i += 3
                } else {
                    answer += 7
                    i += 5
                }
            }
            'e' -> {
                answer += 8
                i += 5
            }
            'n' -> {
                answer += 9
                i += 4
            }
            else -> {
                answer += st[i]
                i++
            }
        }

    }
    return answer.toInt()
}

fun solution2(s: String): Int {
    //코틀린 replace로 문자열치환
    return s
        .replace("zero", "0")
        .replace("one", "1")
        .replace("two", "2")
        .replace("three", "3")
        .replace("four", "4")
        .replace("five", "5")
        .replace("six", "6")
        .replace("seven", "7")
        .replace("eight", "8")
        .replace("nine", "9")
        .toInt()
}