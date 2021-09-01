import java.util.*
import kotlin.collections.ArrayList

// classroom은 N by N (0 ~ N-1)
// table은 N*N by 5
fun main() {
	val sc = Scanner(System.`in`)
	val N = sc.nextInt()
	val classroom = Array(N) { Array(N) {0} }
	val table = Array(N * N) { Array(5) {0} }
	var satisfaction = 0
	for (i in 0 until N * N) {
		for (j in 0 until 5) {
			table[i][j] = sc.nextInt()
		}
	}
	for (i in 0 until N * N) {
		arrange(classroom, table[i], N)
	}
	for (i in 0 until N) {
		for (j in 0 until N) {
			var k = 0
			while (table[k][0] != classroom[i][j]) k++
			val info = table[k]
			satisfaction += satisfy(classroom, info, i, j, N)
		}
	}
	println(satisfaction)
}
fun arrange(classroom:Array<Array<Int>>, info:Array<Int>, N:Int) {
	val a = one(classroom, info, N)
	if (a.size != 1) two(classroom, a, N)
	if (a.size != 1) three(a)

	val i = a[0].first
	val j = a[0].second
	classroom[i][j] = info[0]
	return
}
fun one(classroom:Array<Array<Int>>, info:Array<Int>, N:Int):ArrayList<Pair<Int, Int>> {
	var ret = ArrayList<Pair<Int, Int>>()
	var nearFriends = 0
	for (i in 0 until N) {
		for (j in 0 until N) {
			var eachNearFriends = 0
			if (classroom[i][j] != 0) continue
			if (i > 0 && info.contains(classroom[i - 1][j])) eachNearFriends++
			if (i < N - 1 && info.contains(classroom[i + 1][j])) eachNearFriends++
			if (j > 0 && info.contains(classroom[i][j - 1])) eachNearFriends++
			if (j < N - 1 && info.contains(classroom[i][j + 1])) eachNearFriends++
			nearFriends = if (nearFriends >= eachNearFriends) nearFriends else eachNearFriends
		}
	}
	for (i in 0 until N) {
		for (j in 0 until N) {
			var eachNearFriends = 0
			if (classroom[i][j] != 0) continue
			if (i > 0 && info.contains(classroom[i - 1][j])) eachNearFriends++
			if (i < N - 1 && info.contains(classroom[i + 1][j])) eachNearFriends++
			if (j > 0 && info.contains(classroom[i][j - 1])) eachNearFriends++
			if (j < N - 1 && info.contains(classroom[i][j + 1])) eachNearFriends++
			if (nearFriends == eachNearFriends) ret.add(Pair(i, j))
		}
	}
	return ret
}
fun two(classroom:Array<Array<Int>>, a:ArrayList<Pair<Int, Int>>, N:Int) {
	var Empty = 0
	for (t in a.indices) {
		var eachEmpty = 0
		val i = a[t].first
		val j = a[t].second

		if (i > 0 && classroom[i - 1][j] == 0) eachEmpty++
		if (i < N - 1 && classroom[i + 1][j] == 0) eachEmpty++
		if (j > 0 && classroom[i][j - 1] == 0) eachEmpty++
		if (j < N - 1 && classroom[i][j + 1] == 0) eachEmpty++

		Empty = if (Empty >= eachEmpty) Empty else eachEmpty
	}
	for (t in a.size - 1 downTo 0) {
		var eachEmpty = 0
		val i = a[t].first
		val j = a[t].second

		if (i > 0 && classroom[i - 1][j] == 0) eachEmpty++
		if (i < N - 1 && classroom[i + 1][j] == 0) eachEmpty++
		if (j > 0 && classroom[i][j - 1] == 0) eachEmpty++
		if (j < N - 1 && classroom[i][j + 1] == 0) eachEmpty++
		if (Empty > eachEmpty) a.removeAt(t)
	}
}
fun three(a:ArrayList<Pair<Int, Int>>) {
	var iMin = Int.MAX_VALUE
	for (t in a.indices) {
		iMin = if (iMin <= a[t].first) iMin else a[t].first
	}
	for (t in a.size - 1 downTo 0) {
		if (iMin != a[t].first) a.removeAt(t)
	}
	while (a.size != 1) {
		if (a[0].second > a[1].second) a.removeAt(0)
		else a.removeAt(1)
	}
}
fun satisfy(classroom:Array<Array<Int>>, info:Array<Int>, i:Int, j:Int, N:Int):Int {
	var nearFriends = 0
	if (i > 0 && info.contains(classroom[i - 1][j])) nearFriends++
	if (i < N - 1 && info.contains(classroom[i + 1][j])) nearFriends++
	if (j > 0 && info.contains(classroom[i][j - 1])) nearFriends++
	if (j < N - 1 && info.contains(classroom[i][j + 1])) nearFriends++
	when (nearFriends) {
		1 -> return 1
		2 -> return 10
		3 -> return 100
		4 -> return 1000
	}
	return 0
}
