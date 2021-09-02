import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var st:StringTokenizer = StringTokenizer(readLine(), " ")
    var N:Int = st.nextToken().toInt()
    var M:Int = st.nextToken().toInt()
    var map:Array<IntArray> = Array<IntArray>(N+1) { IntArray(M+1) }
    var res:Int = 0

    // 입력받기
    for (i in 1..N){
        var s = readLine()
        for (j in 1..M){
            map[i][j] = s[j-1].digitToInt()
        }
    }

    // 찾기
    for (i in 1..N)
        for (j in 1..M){
            if(map[i][j] != 0){
                var arr:IntArray = IntArray(3)
                arr[0] = map[i-1][j]
                arr[1] = map[i][j-1]
                arr[2] = map[i-1][j-1]

                Arrays.sort(arr)
                map[i][j] = arr[0] + 1
                if(res < map[i][j])
                    res = map[i][j]
            }
        }

    print(res * res)
}
