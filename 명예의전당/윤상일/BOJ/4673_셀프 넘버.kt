val arr = Array<Int>(10001) {0}

fun cut(num:Int):ArrayList<Int> {
	val ret = ArrayList<Int>()
	var numvar = num
	while(numvar!=0){
		ret.add(numvar%10)
		numvar/=10
	}
	return ret
}

fun sn(num:Int) {
	if (num > 10000) return
	val cutArr = cut(num)
	var next:Int = num
	for (i in cutArr.indices)
		next += cutArr[i]
	if (next > 10000) return
	arr[next] = 1
	sn(next)
}

fun main() {
	for (i in 1..10000) {
		if (arr[i] == 0) sn(i)
	}
	for (i in 1..10000) {
		if (arr[i] == 0) println(i)
	}
}
