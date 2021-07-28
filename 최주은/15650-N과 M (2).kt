import java.util.*
import kotlin.collections.ArrayList

class `15650` {
}

var N:Int = 0
var M:Int = 0
var visited:BooleanArray = BooleanArray(10) { false }

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringTokenizer(readLine(), " ")
    N = sb.nextToken().toInt()
    M = sb.nextToken().toInt()

    DFS(ArrayList(), 1)
}

fun DFS(arr:ArrayList<Int>,now:Int){
    if(arr.size >= M){
        arr.forEach{ print("$it ")}
        println()
        return;
    }

    for (i in now..N){
        if(!visited[i]) {
            visited[i] = true
            arr.add(i)
            DFS(arr,i+1)
            arr.remove(i)
            visited[i]=false
        }
    }
}
