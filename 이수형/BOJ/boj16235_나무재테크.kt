package today4

import java.util.*

var N = 0;
var M = 0
var K = 0
var treelist = ArrayList<tree>()
var templist = ArrayList<tree>()
lateinit var addlist: Array<Array<Int>>
lateinit var board: Array<Array<Int>>
var dx = arrayOf(1, 1, 1, 0, 0, -1, -1, -1)
var dy = arrayOf(1, 0, -1, 1, -1, 1, 0, -1)

data class tree(var x: Int, var y: Int, var age: Int, var alive: Boolean)

fun main() = with(Scanner(System.`in`)) {
    N = nextInt()
    M = nextInt()
    K = nextInt()
    addlist = Array(N) { Array(N) { nextInt() } }
    board = Array(N) { Array(N) { 5 } }
    repeat(M) {
        treelist.add(tree(nextInt() - 1, nextInt() - 1, nextInt(), true))
    }
    repeat(K) {
        treelist.sortBy { it.age }
        treelist.forEach {
            if (board[it.x][it.y] >= it.age) {
                board[it.x][it.y] -= it.age
                it.age++
            } else {
                it.alive = false
            }
        }

        treelist.forEach {
            if (!it.alive) {
                board[it.x][it.y] += it.age / 2
            }
        }
        treelist.removeIf { !it.alive }
        treelist.forEach {
            if (it.age % 5 == 0) {
                templist.add(it)
            }
        }
        addnewtree()
        for (i in 0 until N) {
            for (j in 0 until N) {
                board[i][j] += addlist[i][j]
            }
        }
    }
    print(treelist.size)
}

fun addnewtree() {
    templist.forEach {
        for (i in dx.indices) {
            if (isNotWall(it.x + dx[i], it.y + dy[i])) {
                treelist.add(tree(it.x + dx[i], it.y + dy[i], 1, true))
            }

        }
    }
    templist = ArrayList()
}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until N