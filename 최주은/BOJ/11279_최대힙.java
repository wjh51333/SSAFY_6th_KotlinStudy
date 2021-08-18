package com.ssafy.algorithm.boj11279

/**
 * Max Heap = 각 노드의 키 값이 자식의 키 값보다 작지 않은(=크거나 같은) 트리
 * 최대 힙은 최대 트리+완전 이진 트리 이다.
 */

class Main {
}

fun main() = with(System.`in`.bufferedReader()) {
    var N : Int = readLine().toInt()
    var maxHeap = ArrayList<Int>()
    maxHeap.add(0)

    for (i in 0 until N){
        var x:Int = readLine().toInt()

        if(x == 0) {
            if (maxHeap.size == 1)
                println(0)
            else
                println(pop(maxHeap))
        }else{
            maxHeap.add(x)
            var idx = maxHeap.size-1
            while(idx > 1 && maxHeap[idx/2] < maxHeap[idx] ){
                swap(maxHeap, idx)
                idx /= 2
            }
        }
    }
}

fun swap(maxHeap:ArrayList<Int>, idx:Int){
    var t = maxHeap[idx]
    maxHeap[idx] = maxHeap[idx/2]
    maxHeap[idx/2] = t
}

fun pop(heap:ArrayList<Int>): Int{
    var deleteItem = heap[1]

    heap[1] = heap[heap.size-1]
    heap.removeAt(heap.size-1)

    var pos:Int = 1
    while(pos*2 < heap.size){ // 왼쪽 자식까지 array 범위 체크
        var min:Int = heap[pos*2]
        var minPos:Int = pos*2

        if(pos*2+1 < heap.size && min < heap[pos*2+1]){
            min = heap[pos*2+1]
            minPos = pos*2+1
        }

        if(heap[pos] > min)
            break

        var temp = heap[pos]
        heap[pos] = heap[minPos]
        heap[minPos] = temp
        pos = minPos
    }
    return deleteItem
}
