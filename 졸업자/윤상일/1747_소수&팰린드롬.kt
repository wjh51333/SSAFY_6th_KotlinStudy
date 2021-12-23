fun main() {
	val arr = IntArray(1003002) { 1 }
	arr[0] = 0
	arr[1] = 0
	for (i in 2 .. 1001) {
		if (arr[i] == 0) continue
		for (j in i + i .. 1003001 step i) {
			if (arr[j] == 1) arr[j] = 0
		}
	}
	val N = readLine()!!.toInt()
	for (i in N..1003001) {
		if (arr[i] == 1 && pldr(i)) {
			println(i)
			return
		}
	}
}

private fun pldr(a:Int):Boolean {
	val aStr:String = a.toString()
	for (i in 0..aStr.length/2) {
		if (aStr[i] != aStr[aStr.length - 1 - i]) return false
	}
	return true
}
