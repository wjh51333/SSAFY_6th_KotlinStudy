package boj.`1874_스택수열`

import java.util.*
import kotlin.system.exitProcess

var nums = Array<Int>(readLine()!!.toInt()) { readLine()!!.toInt() }

fun main() {
    var stack = Stack<Int>()
    var result:StringBuilder = StringBuilder()
    var pointer:Int = 0
    var now = 1

    while (pointer < nums.size){

        if(stack.isEmpty()){
            stack.push(now)
            now++
            result.append("+\n")
            continue
        }

        if(nums[pointer] > stack.peek()){
            stack.push(now)
            result.append("+\n")
            now++
            continue
        }

        if (nums[pointer] == stack.peek()){
            result.append("-\n")
            pointer++
            stack.pop()
            continue
        }

        if(nums[pointer] < stack.peek()){
            print("NO")
            exitProcess(0)
        }
    }

    print(result)
}
