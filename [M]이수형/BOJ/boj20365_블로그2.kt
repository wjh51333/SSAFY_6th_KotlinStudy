fun main() {
    readLine()
    val st = readLine()!!.split("")
    var cntR = 1
    var cntB = 1
    for (i in st.indices) {
        cntR += if (i != st.size - 1 && st[i] == "R" && st[i + 1] == "R") 0 else if (st[i] == "R") 1 else 0
        cntB += if (i != st.size - 1 && st[i] == "B" && st[i + 1] == "B") 0 else if (st[i] == "B") 1 else 0
    }
    print(cntB.coerceAtMost(cntR))
}