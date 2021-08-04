// 수정중

import java.util.*
import kotlin.collections.ArrayList

fun solution(info: Array<String>, query: Array<String>): IntArray {
	val answer: IntArray
	val group = mutableMapOf<String, ArrayList<Int>>()
	val infoList = Array<List<String>>(info.size) { i -> info[i].split(" ") }
	info.forEachIndexed { index, s ->
		mapping(index, s, group, infoList)
	}
	val t = group.toList()
	t.forEach {i->
		i.second.sortBy { infoList[it][4].toInt() }
	}
	val newGroup = t.toMap().toMutableMap()
	answer = IntArray(query.size) { i ->
		newGroup[query[i].replace("[0-9]| |and".toRegex(), "")]?.count {
			it >= query[i].slice(query[i].lastIndex - 2 .. query[i].lastIndex).toInt()
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

fun main() {
	val arr = arrayOf("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
	val query = arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150")
	println(solution(arr, query).contentToString())
}
