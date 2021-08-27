import java.util.*

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        val checked = BooleanArray(n) { false }
        val queue: Queue<Int> = LinkedList()

        for (i in 0 until n) {
            if (!checked[i]) {
                queue.add(i)
                answer += 1
                checked[i] = true
            }

            while (!queue.isEmpty()) {
                var node = queue.remove()

                for (j in 0 until computers[node].size) {
                    if (!checked[j] && computers[node][j] == 1) {
                        queue.add(j)
                        checked[j] = true
                    }
                }
            }
        }
        return answer
    }
}
