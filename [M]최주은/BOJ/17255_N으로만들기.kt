package boj.`17255_N으로만들기`

val num = readLine()!!.trim()
val hashSet = HashSet<String>()
var limit = num.length * (num.length+1) /2

fun main() {
    for(i in num.indices){
        dfs(i, i, num[i].toString())
    }

    print(hashSet.size)
}

fun dfs(left: Int, right:Int, selectNum:String) {
    if(selectNum.length == limit){
        hashSet.add(selectNum)
        return
    }

    if(left > 0) dfs(left-1, right, selectNum+num.substring(left-1,right+1))
    if(right < num.length-1) dfs(left, right+1, selectNum+num.substring(left, right+2))
}

//fun main() {
//    var res = 0
//
//    for (i in num.indices){
//        var left = i-1
//        var right = i+1
//        var now = -1
//
//        while (left > 0 || right < num.size){
//
//            if(now == 1 && left >= 0) break
//            if(now!= 1 && left >= 0){
//                left--
//                res++
//                now = 1
//            }
//
//            if(now == 2 && right < num.size) break;
//            if(now!= 2 && right < num.size){
//                right++
//                res++
//                now = 2
//            }
//        }
//    }
//
//    print(res)
//}
