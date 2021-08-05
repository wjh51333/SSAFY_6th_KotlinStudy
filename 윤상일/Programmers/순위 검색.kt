import kotlin.collections.ArrayList

class Solution {
	fun solution(info: Array<String>, query: Array<String>): IntArray {
		val answer: IntArray
		val group = mutableMapOf<String, ArrayList<Int>>()
		val infoList = Array<List<String>>(info.size) { i -> info[i].split(" ") }
		info.forEachIndexed { index, s ->
			mapping(index, s, group, infoList)
		}
		val t = group.toList()
		val newGroup = mutableMapOf<String, IntArray>()
		t.forEach {i->
			i.second.sortBy { infoList[it][4].toInt() }
			newGroup[i.first] = i.second.toIntArray()
		}
		answer = IntArray(query.size) { i ->
			newGroup[query[i].replace("[0-9]| |and".toRegex(), "")]?.count {
				infoList[it].last().toInt() >= query[i].split(" ").last().toInt()
			} ?: 0
		}
		return answer
	}

	fun mapping(index:Int, s:String, group:MutableMap<String, ArrayList<Int>>, infoList: Array<List<String>>) {
		val a = arrayOf("-", infoList[index][0])
		val b = arrayOf("-", infoList[index][1])
		val c = arrayOf("-", infoList[index][2])
		val d = arrayOf("-", infoList[index][3])
		for (atem in a) {
			for (btem in b) {
				for (ctem in c) {
					for (dtem in d) {
						group[atem+btem+ctem+dtem]?.add(index)
							?: run { group[atem+btem+ctem+dtem] = arrayListOf<Int>(index) }
					}
				}
			}
		}
	}
}
