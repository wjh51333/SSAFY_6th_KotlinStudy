val set = HashSet<String>()
var nums: CharArray? = null

fun main() {
    nums = readLine()!!.toCharArray()

    for (i in nums!!.indices)
        dfs(i-1, i+1, "${nums!![i]}", "${nums!![i]}")

    print(set.size)
}

fun dfs(left: Int, right: Int, number: String, route: String) {
    if (left < 0 && right == nums!!.size) {
        set.add(route)
        return
    }

    if (left >= 0)
        dfs(left-1, right, "${nums!![left]}$number", "$route -> ${nums!![left]}$number")
    if (right < nums!!.size)
        dfs(left, right+1, "$number${nums!![right]}", "$route -> $number${nums!![right]}")
}