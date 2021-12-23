class Solution {
    val map : MutableMap<String, Int> = setMap()
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        val table = List<MutableList<Int>>(4 * 3 * 3 * 3) { mutableListOf() }

        info.forEach {
            // 언어, 직군, 경력, 음식 정보를 담은 배열, 점수
            val (cList, score) = getInfo(it)

            // 언어, 직군, 경력, 음식 분류별로 테이블에 추가
            for (i in 0 until (1 shl 4)) {
                var idx = 0
                for (j in 0 until 4) {
                    if (i and (1 shl j) != 0) {
                        idx += cList[j]
                    }
                }
                table[idx].add(score)
            }
        }
        
        // 점수를 오름차순으로 정렬
        table.forEach { it.sort() }

        query.forEachIndexed { index, it ->
            val (cList, score) = getInfo(it)
            // 테이블 인덱스 찾기
            var idx = cList.sum()

            // score 이상 점수를 만족하기 시작하는 인덱스 찾기
            var result = table[idx].binarySearch(score)

            if (result < 0) { // score를 찾지 못할 경우 score와 가장 가까운 값의 인덱스를 (-index - 1)로 반환
                result = (result + 1) * -1
            }
            else { // lower bound 찾기
                for (j in result downTo 0) {
                    if (table[idx][j] != score)
                        break
                    result = j
                }
            }
            answer[index] = table[idx].size - result
        }
        return answer
    }

    fun setMap() : MutableMap<String, Int> {
        val map = mutableMapOf<String, Int>()
        map["-"] = 0
        map["cpp"] = 1
        map["java"] = 2
        map["python"] = 3
        map["backend"] = 1
        map["frontend"] = 2
        map["junior"] = 1
        map["senior"] = 2
        map["chicken"] = 1
        map["pizza"] = 2
        return map
    }

    fun getInfo(info : String) : Pair<IntArray, Int> {
        val sinfo = info.split(" ", "and").filter { it.isNotBlank() }
        val score = sinfo.last().toInt()

        val condition = IntArray(4) { 0 }
        var mult = 27
        sinfo.subList(0, 4).forEachIndexed { index, s ->
            condition[index] = map[s]!! * mult
            mult /= 3
        }

        return Pair(condition, score)
    }
}