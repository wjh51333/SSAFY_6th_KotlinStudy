fun main() {
    var sugar = readLine()!!.toInt()

    if (sugar % 5 == 0) {
        println(sugar / 5)
        return
    }

    var count = 5001
    var kg_5 = 0
    while (sugar > 5) {
        var sum = 0
        if (sugar % 3 == 0) {
            sum = kg_5 + (sugar / 3)
            count = Math.min(count, sum)
        }

        sugar -= 5
        kg_5++
    }

    if(sugar % 3 == 0)
        count = Math.min(count, kg_5 + 1)

    if (count != 5001)
        println(count)
    else
        print(-1)
}
