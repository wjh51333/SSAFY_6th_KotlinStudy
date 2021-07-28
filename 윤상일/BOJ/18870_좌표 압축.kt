import java.util.*


private val map: MutableMap<Int, Int> = HashMap()
private val sb = StringBuilder()

fun main(args: Array<String>) {
	val sc = Scanner(System.`in`)
	val N = sc.nextInt()
	val nums = IntArray(N)
	val sortNums = IntArray(N)
	for (i in 0 until N) {
		val num = sc.nextInt()
		nums[i] = num
		sortNums[i] = num
	}
	Arrays.sort(sortNums)
	var cnt = 0
	for (i in 0 until N) {
		if (map[sortNums[i]] == null) {
			map[sortNums[i]] = cnt++
		}
	}
	for (i in 0 until N) {
		sb.append(map[nums[i]]).append(" ")
	}
	println(sb.toString())
}
