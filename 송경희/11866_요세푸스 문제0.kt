



    fun main() {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        var circle = mutableListOf<Int>()
        var copy = mutableListOf<Int>()
        var sb = StringBuffer("<")
        for(i in 1..n)
            circle.add(i)
        while(!circle.isEmpty()) {
            for (i in 0 until k-1) {
                var r = circle.removeAt(0)
                circle.add(r)
            }
            if(circle.size == 1)
                sb.append("${circle.removeAt(0)}>")
            else
                sb.append("${circle.removeAt(0)}, ")

        }
        print(sb)
    }


