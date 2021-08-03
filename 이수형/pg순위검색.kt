import java.util.*

class Solution {
    //맵에 다 넣어서 기본 세팅 맵 저장
    fun setMap(map: HashMap<String, ArrayList<Int>>) {
        val first = arrayOf("cpp", "java", "python", "-")
        val second = arrayOf("backend", "frontend", "-")
        val third = arrayOf("junior", "senior", "-")
        val fourth = arrayOf("chicken", "pizza", "-")

        for (i in first.indices) {
            for (j in second.indices) {
                for (k in third.indices) {
                    for (l in fourth.indices) {
                        map[first[i] + second[j] + third[k] + fourth[l]] = ArrayList()
                    }
                }
            }
        }
    }

    //값이 들어오면 16가지 경우에 수에 맞게 점수가 모두 입력됨
    fun input(map: HashMap<String, ArrayList<Int>>, info: String, value: Int) {
        val st = info.split(" ")
        val first = arrayOf(st[0], "-")
        val second = arrayOf(st[1], "-")
        val third = arrayOf(st[2], "-")
        val fourth = arrayOf(st[3], "-")

        for (i in first.indices) {
            for (j in second.indices) {
                for (k in third.indices) {
                    for (l in fourth.indices) {
                        map[first[i] + second[j] + third[k] + fourth[l]]!!.add(value)
                    }
                }
            }
        }
    }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        val map = HashMap<String, ArrayList<Int>>()
        setMap(map)
        for (i in info.indices) {
            val value = info[i].split(" ")
            input(map, info[i], value[4].toInt())
        }

        //속도를위해 sort후 이진탐색
        for ((_, value) in map) {
            value.sort()
        }
        map.forEach { print(it) }
        for (i in query.indices) {
            val st = query[i].split(" ")
            val value = st[7].toInt()
            val key = st[0] + st[2] + st[4] + st[6]
            val result = map[key]!!

            //JAVA의 binarySearch를 사용하였으며 이것은 값이 있으면 그 값의 인덱스를 리턴
            var num = Collections.binarySearch(result, value)

            //오름차순 정렬이므로  1 2 3 3 4 5 6 7 에서 3 이상을 찾는다면 가장앞의 3의 인덱스를 찾고 길이에서 빼주면 결과가 나옴
            if (num >= 0) {
                for (j in num - 1 downTo 0) {
                    num = if (result[num] > result[j]) break else j
                }
                answer[i] = result.size - num
            } else {
                //없으면 자기 자리를 찾아 마이너스를 붙여 리턴해줌 10개중에 5번째 자리 뒤에 자기자리면 -6 리턴하는 식
                answer[i] = result.size + num + 1
            }
        }
        return answer
    }
}