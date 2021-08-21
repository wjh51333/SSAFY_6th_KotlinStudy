import java.util.*

fun main() = with(Scanner(System.`in`)) {

    //구현 아이디어 Integer.parseInt(123, 10) -> 123을 10진수로 변환
    // 이것을 이용하여 두 수를 2~36진수로 비교하며 변환
    val st = nextLine().split(" ")
    val first = st[0]
    val second = st[1]

    //이것은 2~36진수로 돌때 만약 3이 나왔는데 2진수로 변환할수없으니 그 중에 가장큰 값을 뽑아서
    // x ~ 36진수로 돌리게 하기위해 그 값을 찾아서 range를 줌
    //first.split("").sortedDescending()[0] -> 정렬을통해 가장큰 값 뽑고 .toCharArray()[0].code -> 아스키코드변환
    var temp = first.split("").sortedDescending()[0].toCharArray()[0].code
    //range는 0~9이면 '0'값인 48빼고 a~z이면 'a'값인 97에서 10을 더한값에 +1 -> 범위설정때문
    val range1 = if (temp < 65) temp - 48 else temp - 86
    temp = second.split("").sortedDescending()[0].toCharArray()[0].code
    val range2 = if (temp < 65) temp - 48 else temp - 86
    var cnt = 0
    var s1 = 0
    var s2 = 0

    //2^63승이상 을 Integer.parseInt해버리면 NumberFormatException이 나서 예외로 그냥 없애버림
    try {
        for (i in 36 downTo range1) {
            for (j in 36 downTo range2) {
                if (i != j && (Integer.parseInt(first, i) == Integer.parseInt(second, j))) {
                    cnt++
                    s1 = i
                    s2 = j
                }
            }
        }

    } catch (e: NumberFormatException) {
    }
    //출력
    print(if (cnt == 1) "${Integer.parseInt(first, s1)} $s1 $s2" else if (cnt > 1) "Multiple" else "Impossible")

}