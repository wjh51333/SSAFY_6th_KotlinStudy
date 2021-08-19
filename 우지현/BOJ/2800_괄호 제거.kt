private val answer = mutableListOf<String>()
private var exp = ""

fun main() = with(System.`in`.bufferedReader()) {
    val bw = System.out.bufferedWriter()
    exp = readLine()
    solve(0, "", 0, 0)
    answer.sort()
    answer.forEach { bw.write("$it\n") }
    bw.flush()
}

private fun solve(idx : Int, now : String, flag : Int, cnt : Int) {
    if (idx == exp.length) {
        if (now != exp && !answer.contains(now)) answer.add(now)
        return
    }

    if (exp[idx] == '(') {
        solve(idx + 1, now, flag, cnt + 1) // 괄호 추가 X
        solve(idx + 1, now + exp[idx], flag or (1 shl (cnt + 1)), cnt + 1) // 괄호 추가
    } else if (exp[idx] == ')') {
        if (flag and (1 shl cnt) != 0) // 여는 괄호가 추가되어있다면 닫는 괄호 추가
            solve(idx + 1, now + exp[idx], flag xor (1 shl cnt), cnt - 1)
        else // 여는 괄호가 없을 경우 추가 X
            solve(idx + 1, now, flag, cnt - 1)
    } else {
        var last = idx + 1
        while (last < exp.length && exp[last] != '(' && exp[last] != ')') last++
        solve(last, now + exp.substring(idx, last), flag, cnt)
    }
}