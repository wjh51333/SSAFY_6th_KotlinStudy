//엄청난 하드코딩

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private val t1 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(0, 3)) // ㅡ
private val t2 = arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0)) // ㅣ

private val t3 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1)) //ㅁ

private val t4 = arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(2, 1)) //L
private val t5 = arrayOf(Pair(0, 1), Pair(1, 1), Pair(2, 1), Pair(2, 0))// ㅢ

private val t18 = arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(0, 1))
private val t19 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(2, 1))
private val t6 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 2)) // ㄱ
private val t7 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 0))

private val t8 = arrayOf(Pair(1, 0), Pair(1, 1), Pair(1, 2), Pair(0, 0))
private val t9 = arrayOf(Pair(1, 0), Pair(1, 1), Pair(1, 2), Pair(0, 2))

private val t10 = arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(2, 1))
private val t11 = arrayOf(Pair(0, 1), Pair(1, 0), Pair(1, 1), Pair(2, 0))

private val t12 = arrayOf(Pair(0, 1), Pair(0, 2), Pair(1, 0), Pair(1, 1))
private val t13 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(1, 2))

private val t14 = arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 1))
private val t15 = arrayOf(Pair(1, 0), Pair(1, 1), Pair(1, 2), Pair(0, 1))

private val t16 = arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(1, 1))
private val t17 = arrayOf(Pair(0, 1), Pair(1, 1), Pair(2, 1), Pair(1, 0))

private var N = 0
private var M = 0

data class Pair(val x: Int, val y: Int)

fun main() = with(Scanner(System.`in`)) {
    val arr = ArrayList<Array<Pair>>()
    arr.add(t1);arr.add(t2);arr.add(t3);arr.add(t4);arr.add(t5);arr.add(t6);arr.add(t7);arr.add(t8);arr.add(t9);arr.add(
    t10)
    arr.add(t11);arr.add(t12);arr.add(t13);arr.add(t14);arr.add(t15);arr.add(t16);arr.add(t17);arr.add(t18);arr.add(t19)
    N = nextInt()
    M = nextInt()
    var board = Array(N) { Array(M) { nextInt() } }
    var max = 0
    for (i in 0 until N) {
        for (j in 0 until M) {

            for (list in arr) {
                var cnt = 0;
                for (k in 0..3) {
                    val newx = i + list[k].x
                    val newy = j + list[k].y
                    if (isNotWall(newx, newy)) {
                        cnt += board[newx][newy]
                    }
                }
                max = max(max, cnt)
            }

        }
    }

    print(max)

}

fun isNotWall(x: Int, y: Int): Boolean = x in 0 until N && y in 0 until M

