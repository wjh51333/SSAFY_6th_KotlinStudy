import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var cnt = 0
    var max = 0
    var save = ArrayList<Pair<Int, Int>>()
    repeat(nextInt()) {
        save.add(Pair(nextInt(), 1))
        save.add(Pair(nextInt(), -1))
    }
    //다중배열 정렬시 sortedWith의 comparBy({it.first()}) <= 첫번째 기준으로
    // 혹은 sortBy, 중요한것은 it.first 등으로 쉽게 comparable구현없이 가능
    // comparBy({it.first()},{it.second()}) <= 첫번째하고 같으면 두번쨰꺼 기준
    
    //여기서는 max를 찾으므로 빼기를 먼저 해주어 같은시간에서의 중복방지
    save.sortWith(compareBy({ it.first }, { it.second }))
    save.forEach { cnt += it.second;max = Integer.max(max, cnt) }
    print(max)
}
