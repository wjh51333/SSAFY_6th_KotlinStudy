import java.lang.NumberFormatException

fun main() {
	var X:Long = 0
	var A:Int = 0
	var B:Int = 0
	var xa:String
	var xb:String
	var flag = 0
	var AUnderBound = 0
	var BUnderBound = 0

	readLine()!!.split(" ").let {
		xa = it[0]
		xb = it[1]
	}

	AUnderBound =
		if (xa.toCharArray().maxOrNull()!!.isDigit())
			xa.toCharArray().maxOrNull()!!.code - '0'.code + 1
		else
			xa.toCharArray().maxOrNull()!!.code - 'a'.code + 11
	BUnderBound =
		if (xb.toCharArray().maxOrNull()!!.isDigit())
			xb.toCharArray().maxOrNull()!!.code - '0'.code + 1
		else
			xb.toCharArray().maxOrNull()!!.code - 'a'.code + 11

	if (xa == "0" && xb == "0") {
		println("Multiple")
		return
	}

	try {
		for (i in AUnderBound..36) {
			for (j in BUnderBound..36) {
				if (i == j) continue
				val Xtmp = xa.toLong(i)
				if (Xtmp == xb.toLong(j)) {
					if (flag == 0) {
						A = i
						B = j
						flag = 1
						X = Xtmp
					} else {
						flag = 2
						break;
					}
				}
				if (flag == 2) break
			}
		}
	} catch (e:NumberFormatException) {
		println("Impossible")
		return
	}

	when (flag) {
		0 -> println("Impossible")
		1 -> println("$X $A $B")
		2 -> println("Multiple")
	}
}
