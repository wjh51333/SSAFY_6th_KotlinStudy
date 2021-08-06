class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)
        val sinfo = List<List<String>>(info.size) { i -> info[i].split(" ") }

        query.forEachIndexed { index, it ->
            // 개발언어, 직군, 경력, 소울푸드, 점수
            val tmp = it.split(" ", "and").filter { it.isNotBlank() }

            // 개발언어, 직군, 경력, 소울푸드
            val condition = tmp.subList(0, 4).filter { !it.equals("-") }

            var result = sinfo.filter { it.containsAll(condition) }
            answer[index] = result.count { it.last().toInt() >= tmp.last().toInt() }
        }
        return answer
    }
}