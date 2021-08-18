import java.util.*

var map = HashMap<Int, Int>()
var stack = Stack<Int>()
var set = HashSet<String>()
lateinit var st: Array<String>
fun main() = with(Scanner(System.`in`)) {

    val input = nextLine()
    st = input.split("").toTypedArray()
    var i = 0
    // String 배열로 입력받은 식에서 괄호만 따로 쌍을 잡아서 map에 넣어줌
    st.forEach { if (it == "(") stack.push(i++) else if (it == ")") map[stack.pop()] = i++ else i++ }
    dfs(0, "")
    // 정렬후 출력
    set.toSortedSet().forEach { if (it != input) println(it) }
}
fun dfs(index: Int, s: String) {
    if (index != st.size) {
        if (map.containsKey(index)) {
            st[index] = "";
            st[map[index]!!] = ""
            dfs(index + 1, s + st[index])
            st[index] = "(";
            st[map[index]!!] = ")"
        }
        dfs(index + 1, s + st[index])
        return
    }
    set.add(s)
}