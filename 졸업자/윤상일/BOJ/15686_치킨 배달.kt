import java.util.*
import kotlin.math.abs

var result = 300000
lateinit var map1:Array<Array<Int>>
fun main() {
	// 입력값 받기, 치킨집의 수를 count한다.
	val sc = Scanner(System.`in`)
	val N = sc.nextInt()
	val M = sc.nextInt()
	map1 = Array(N) { Array(N) {0} }
	var chickenCnt = 0
	for (i in 0 until N) {
		for (j in 0 until N) {
			val tmp = sc.nextInt()
			map1[i][j] = tmp;
			if (tmp == 2) chickenCnt++
		}
	}

	// 입력할때 집은 1, 치킨집은 2로 입력되지만, 문제의 편리한 풀이를 위해
	// 각 치킨집을 1~chickenCnt번, 집을 chickenCnt+1~chickenCnt+(가구 수)번으로
	// re-indexing 한다. (ex: 치킨집 3개 집 4개 => 1~3 치킨집, 4~7 집)
	var c = 1
	var h = chickenCnt + 1
	for (i in 0 until N) {
		for (j in 0 until N) {
			if (map1[i][j] == 1) map1[i][j] = h++
			else if (map1[i][j] == 2) map1[i][j] = c++
		}
	}

	// Delivery Distance. DD[n][m]은 n번 치킨집에서 바라본 m번 집까지의 거리이다.
	// 이 때, c <= m <= h-1
	val DD = Array(c) { Array(h) { 0 } }

	for (i in 1 until c) {
		var x = 0
		var y = 0
		ff@for (_y in 0 until N) {
			for (_x in 0 until N) {
				if (map1[_y][_x] == i) {
					x = _x
					y = _y
					break@ff
				}
			}
		}
		setDD(x, y, c, h, DD[i], N)
	}

	// 1~c-1 치킨집 中 M개 조합 뽑을 배열. 0이면 안뽑힌 것 1이면 뽑힌 것
	val choice = Array<Int>(c) {0}

	// 조합으로 뽑고, 뽑은 조합이 최선인지 확인하여 최선일 때마다 업데이트
	combAndCompare(choice, c, M, DD, 0, 1)
	println(result)
}

fun setDD(x:Int, y:Int, c:Int, h:Int, DDeach:Array<Int>, N:Int) {
	for (i in 0 until N) {
		for (j in 0 until N) {
			if (map1[i][j] >= c) {
				DDeach[map1[i][j]] = abs(i-y) + abs(j-x)
			}
		}
	}
}

fun combAndCompare(choice:Array<Int>, c:Int, M:Int, DD:Array<Array<Int>>, cnt:Int, ii:Int) {
	if (cnt == M) {
		val city = Array(DD[0].size) { 1000 }
		for (i in 1 until c) {
			if (choice[i] == 1) {
				city.forEachIndexed { index, _ ->
					city[index] = Math.min(city[index], DD[i][index])
				}
			}
		}
		result = Math.min(result, city.sum())
	} else {
		for (i in ii until c) {
			choice[i] = 1
			combAndCompare(choice, c, M, DD, cnt + 1, i + 1)
			choice[i] = 0
		}
	}
}
