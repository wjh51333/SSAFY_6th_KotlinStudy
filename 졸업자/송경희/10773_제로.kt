

fun main()  {
        val n = readLine()!!.toInt()
        var stack = mutableListOf<Int>()
        for(i in 0 until n){
            val input = readLine()!!.toInt()
            if(input == 0)
                stack.removeAt(stack.size-1)
            else
                stack.add(input)
        }
        var sum = 0
        for(i in 0 until stack.size)
            sum += stack[i]!!

        print(sum)
    }
