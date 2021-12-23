import java.util.*
import kotlin.math.abs

private var N = 0
private var L = 0
private var R = 0
lateinit var world:Array<Array<Int>>
lateinit var union:Array<Array<Int>>
lateinit var unionCountries:Array<Int>
private var days = 0
private var unionCnt = 0
lateinit var unionSum:Array<Int>

fun main() {
	val sc = Scanner(System.`in`)
	N = sc.nextInt()
	L = sc.nextInt()
	R = sc.nextInt()
	world = Array(N) { Array(N) {0} }
	for (i in 0 until N)
		for (j in 0 until N)
			world[i][j] = sc.nextInt()
	union = Array(N) { Array(N) {0} }
	while(true) {
		if (openWorld()) {
			days++
			moveWorld()
			breakUnion()
		} else break
	}
	println(days)
}

fun openWorld():Boolean {
	var isChanged = false
	for (i in 0 until N) {
		for (j in 0 until N) {
			if (union[i][j] == 0) {
				if (isChanged) dfs(i, j, 0)
				else isChanged = dfs(i, j, 0)
			}
		}
	}
	return isChanged
}

fun dfs(i:Int, j:Int, depth:Int):Boolean {
	if (canGo(i, j, 1, 0) ||
		canGo(i, j, -1, 0) ||
		canGo(i, j, 0, 1) ||
		canGo(i, j, 0, -1)) {
		if (depth == 0) unionCnt++
		union[i][j] = unionCnt
	} else {
		if (depth != 0) union[i][j] = unionCnt
		return false
	}

	if (canGo(i, j, -1, 0)) dfs(i-1, j, depth+1)
	if (canGo(i, j, 1, 0)) dfs(i+1, j, depth+1)
	if (canGo(i, j, 0, -1)) dfs(i, j-1, depth+1)
	if (canGo(i, j, 0, 1)) dfs(i, j+1, depth+1)

	return true
}

fun canGo(i:Int, j:Int, a:Int, b:Int):Boolean =
		i+a>=0 && j+b>=0 && i+a<N && j+b<N &&
		union[i+a][j+b]==0 &&
		abs(world[i][j] - world[i+a][j+b]) >= L &&
		abs(world[i][j] - world[i+a][j+b]) <= R

fun moveWorld() {
	unionCountries = Array(unionCnt+1) { 0 }
	unionSum = Array(unionCnt+1) { 0 }
	for (i in 0 until N) {
		for (j in 0 until N) {
			if (union[i][j] != 0) {
				unionCountries[union[i][j]] += 1
				unionSum[union[i][j]] += world[i][j]
			}
		}
	}
	for (i in 0 until N) {
		for (j in 0 until N) {
			if (union[i][j] != 0) world[i][j] = unionSum[union[i][j]]/unionCountries[union[i][j]]
		}
	}
}

fun breakUnion() {
	unionCountries.fill(0)
	unionCnt = 0
	unionSum.fill(0)
	union.forEach { it.fill(0) }
}
