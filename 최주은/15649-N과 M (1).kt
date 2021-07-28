import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

class `15649` {
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 입력받기
    val token = StringTokenizer(readLine(), " ");
    val N = Integer.parseInt(token.nextToken());
    val M = Integer.parseInt(token.nextToken());

    val visited:BooleanArray = BooleanArray(9) {false}

    DFS(visited, ArrayList<Int>(), N, M, 0)
}

fun DFS(visited:BooleanArray, number:ArrayList<Int>, N:Int, M:Int, point:Int){

    if(number.size >= M) {
        number.forEach{ print("$it ") }
        println()
        return
    }else{
        for(i in 1..N) {
            if(!visited[i]) {
                visited[i] = true
                number.add(i)
                DFS(visited, number, N, M, point+1)
                number.remove(i)
                visited[i] = false
            }
        }
    }
}
