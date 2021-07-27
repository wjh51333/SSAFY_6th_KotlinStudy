fun main() {
    val alphabets = IntArray(26)

    val str = readLine()!!.toUpperCase()
    for (c in str) {
        val indx = c - 'A'
        alphabets[indx]++
    }

    var maxCount = 1
    var max = 0
    for (i in 1..25) {
        if (alphabets[i] > alphabets[max]) {
            max = i
            maxCount = 1
        } else if (alphabets[i] == alphabets[max])
            maxCount++
    }

    if (maxCount > 1) {
        println("?")
        return
    }
    print(('A'.plus(max)))
}
