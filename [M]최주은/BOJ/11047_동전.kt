package com.ssafy.algorithm

import java.util.*

class `11047` {
}

fun main() = with(Scanner(System.`in`)) {
    var len:Int = nextInt();
    var money:Int = nextInt();
    var count:Int = 0
    var mClip = IntArray(len) {0}

    // 입력받기
    for (i in len-1 downTo 0){
        mClip[i] = nextInt()
    }

    mClip.forEach {
        count += money/it
        money %= it
    }
    print(count)
}
