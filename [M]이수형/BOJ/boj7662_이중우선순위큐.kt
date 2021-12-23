import java.util.*

fun main() {

    var T = readLine()!!.toInt()
    repeat(T) {
        var K = readLine()!!.toInt()
        //우선순위큐 2개로 쓰면 시간초과가 나서 검색해보니 TreeMAP을 사용해야함
        //TreeMap은 정렬이 자동으로 되고 first, lastkey검색이 되서 앞뒤로 가능
        var q = TreeMap<Int, Int>()
        repeat(K) {
            var temp = readLine()!!.split(" ")
            if (temp[0] == "I") {
                //중복된것이 들어오면 계속 value의 갯수가 증가
                q[temp[1].toInt()] = q.getOrDefault(temp[1].toInt(), 0) + 1
            } else {
                if (q.isNotEmpty()){
                    if (temp[1] == "-1") {
                        var num = q.firstKey()
                        //value는 그수의 갯수를 저장하므로 vaule가 1이면 아예 키를 삭제
                        if (q[num] == 1) {
                            q.remove(num)
                        } else {
                            //아니라면 value값 1
                            q[num] = q[num]!! - 1
                        }
                    } else {
                        var num = q.lastKey()
                        if (q[num] == 1) {
                            q.remove(num)
                        } else {
                            q[num] = q[num]!! - 1
                        }
                    }
                }
            }
        }
        println(if (q.isEmpty()) "EMPTY" else "${q.lastKey()} ${q.firstKey()}")
    }
}