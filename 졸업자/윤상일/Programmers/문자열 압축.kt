import java.util.*

class Solution {
	fun solution(s: String): Int {
		val answer = ArrayList<Int>()
		if (s.length <= 1) return s.length
		for (len in 1 .. s.length/2) {
			val stack = Stack<Pair<Int, String>>()
			var iLast = 0
			for (i in 0 until s.length - len step len) {
				if (!stack.isEmpty() && s.slice(i until i+len) == stack.peek().second) {
					val tmp = stack.pop()
					stack.push(Pair(tmp.first+1, tmp.second))
				} else {
					stack.push(Pair(1, s.slice(i until i+len)))
				}
				iLast = i
			}
			if (s.slice(iLast+len until s.length) == stack.peek().second) {
				val tmp = stack.pop()
				stack.push(Pair(tmp.first+1, tmp.second))
			} else
				stack.push(Pair(1,s.slice(iLast + len until s.length)))
			var zippedLen = 0
			for (item in stack) {
				if (item.first != 1) zippedLen += item.first.toString().length
				zippedLen += item.second.length
			}
			answer.add(zippedLen)
		}
		return answer.min()!!
	}
}
