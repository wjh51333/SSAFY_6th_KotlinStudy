package boj.`16235_나무재테크`

import java.util.*
import kotlin.collections.ArrayDeque

var N = 0 // 맵크기
var M = 0 // M개의 나무
var K = 0 // K년 후의 살아있는 나무
lateinit var map : Array<Array<Int>>
lateinit var s2d2 : Array<Array<Int>>
lateinit var trees : ArrayDeque<Tree>
var dy = arrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
var dx = arrayOf(-1, 0, 1, 1, 1, 0, -1, -1)

data class Tree(val y:Int, val x:Int, var old:Int) : Comparable<Tree>{
    override fun compareTo(other : Tree) : Int{
        return if(this.old < other.old) -1 else if(this.old == other.old) 0 else 1
    }
}

fun main() {
    // 초기화
    val (a,b,c) = readLine()!!.split(" ").map { it.toInt() }
    N = a
    M = b
    K = c
    map = Array(N) { Array(N) {5} }
    trees = ArrayDeque()
    s2d2 = Array(N) { readLine()!!.trim().split(" ").map { it.toInt() }.toTypedArray() }

    for (i in 0 until M){
        val (a2, b2, c2) = readLine()!!.split(" ").map { it.toInt() }
        trees.addFirst(Tree(a2-1, b2-1, c2))
    }
    Collections.sort(trees)

    // K년 동안 사계절 시작
    for (k in 0 until K){
        val dead = ArrayDeque<Tree>()

        // 봄 -> 나무가 자기 나이 만큼 양분을 먹고 나이가 1 증가
        var len = trees.size
        for (i in 0 until len){
            val t = trees.removeFirst()
            if(map[t.y][t.x] < t.old) {
                dead.add(t)
                continue
            }
            map[t.y][t.x] -= t.old
            t.old += 1
            trees.addLast(t)
        }

        // 여름 -> 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
        while (dead.isNotEmpty()){
            val t = dead.removeFirst()
            map[t.y][t.x] += (t.old/2)
        }

        // 가을 -> 나무가 번식한다.
        len = trees.size
        val temp = ArrayDeque<Tree>()
        while (trees.isNotEmpty()){
            val t = trees.removeFirst()
            temp.addLast(t)

            if (t.old % 5 != 0) continue

            for (q in 0 until 8){
                val yy = t.y + dy[q]
                val xx = t.x + dx[q]
                if(yy < 0 || yy >= N || xx < 0 || xx >= N) continue
                temp.addFirst(Tree(yy, xx, 1))
            }
        }
        trees = temp

        // 겨울 -> S2D2가 땅을 돌아다니며 양분을 추구한다.
        for (i in 0 until N){
            for (j in 0 until N){
                map[i][j] += s2d2[i][j]
            }
        }
    }

    print(trees.size)
}


//var N = 0 // 맵크기
//var M = 0 // M개의 나무
//var K = 0 // K년 후의 살아있는 나무
//lateinit var map : Array<Array<Int>>
//lateinit var s2d2 : Array<Array<Int>>
//lateinit var trees : Array<Array<PriorityQueue<Int>>>
//var dy = arrayOf(-1, -1, -1, 0, 1, 1, 1, 0)
//var dx = arrayOf(-1, 0, 1, 1, 1, 0, -1, -1)
//
//fun main() {
//    // 초기화
//    val (a,b,c) = readLine()!!.split(" ").map { it.toInt() }
//    N = a
//    M = b
//    K = c
//    map = Array(N) { Array(N) {5} }
//    trees = Array(N) { Array(N) { PriorityQueue() } }
//    s2d2 = Array(N) { readLine()!!.trim().split(" ").map { it.toInt() }.toTypedArray() }
//
//    for (i in 0 until M){
//        val (a2, b2, c2) = readLine()!!.split(" ").map { it.toInt() }
//        trees[a2-1][b2-1].offer(c2)
//    }
//
//    // K년 동안 사계절 시작
//    for (k in 0 until K){
//        val dead = Array(N){ Array(N){ PriorityQueue<Int>() } }
//        val temp = PriorityQueue<Int>()
//
//        // 봄 -> 나무가 자기 나이 만큼 양분을 먹고 나이가 1 증가
//        for (i in 0 until N){
//            for (j in 0 until N){
//                temp.clear()
//                while (trees[i][j].isNotEmpty()) {
//                    val tree = trees[i][j].poll()
//                    if (map[i][j] < tree) {
//                        dead[i][j].offer(tree)
//                        continue
//                    }
//                    map[i][j] -= tree
//                    temp.offer(tree+1)
//                }
//                trees[i][j].addAll(temp)
//            }
//        }
//
//        // 여름 -> 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
//        for (i in 0 until N){
//            for (j in 0 until N){
//                while (dead[i][j].isNotEmpty()) {
//                    map[i][j] += (dead[i][j].poll()/2)
//                }
//            }
//        }
//
//        // 가을 -> 나무가 번식한다.
//        for (i in 0 until N){
//            for (j in 0 until N){
//                temp.clear()
//                while (trees[i][j].isNotEmpty()){
//                    val tree = trees[i][j].poll()
//                    temp.offer(tree)
//                    if (tree % 5 != 0) continue
//
//                    for (q in 0 until 8){
//                        val yy = i + dy[q]
//                        val xx = j + dx[q]
//                        if(yy < 0 || yy >= N || xx < 0 || xx >= N) continue
//                        trees[yy][xx].offer(1)
//                    }
//                }
//                trees[i][j].addAll(temp)
//            }
//        }
//
//        // 겨울 -> S2D2가 땅을 돌아다니며 양분을 추구한다.
//        for (i in 0 until N){
//            for (j in 0 until N){
//                map[i][j] += s2d2[i][j]
//            }
//        }
//    }
//
//    var res = 0
//    trees.forEach { it.forEach { it2->res+=it2.size } }
//    print(res)
//}
