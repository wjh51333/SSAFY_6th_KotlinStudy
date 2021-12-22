/**
 * HashMap 반례
 * 2
 * 2 BANANA BANANA
 * 2 BANANA BANANANA
 */
package boj.`14725_개미굴`

import java.util.*

class Node {
    val leaf = TreeMap<String, Node>() // Treemap => Key 자동 정렬!, HashMap을 사용했을때는 틀림

    fun print(depth: Int) {
        for (s in leaf.keys) {
            for (i in 0 until depth) {
                print("--")
            }
            println(s)
            leaf[s]?.print(depth + 1)
        }
    }
}

fun main() {
    val N = readLine()!!.toInt()

    val root = Node()
    for (i in 0 until N){
        val st = StringTokenizer(readLine()!!, " ")
        val len = st.nextToken().toInt()
        var node = root
        for (j in 0 until len){
            node = node.leaf.computeIfAbsent(st.nextToken()) { Node() }
        }
    }

    root.print(0)
}
