package com.ssafy.algorithm

import java.util.*

class `5086` {
}

fun main() = with(System.`in`.bufferedReader()){
    while (true){
        var st = StringTokenizer(readLine(), " ")
        var a:Int = Integer.parseInt(st.nextToken())
        var b:Int = Integer.parseInt(st.nextToken())

        if(a==0 && b==0)
            break

        if(b%a==0) {
            println("factor")
            continue
        }

        if(a%b==0){
            println("multiple")
            continue
        }

        println("neither")
    }
}
