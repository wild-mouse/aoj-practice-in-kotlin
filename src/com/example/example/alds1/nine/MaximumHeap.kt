package com.example.alds1.nine

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val h = IntArray(n + 1)
    IntRange(1, n).forEachIndexed { _, v ->
        h[v] = sc.nextInt()
    }

    buildMaxHeap(h)

    h.forEachIndexed { i, v ->
        if (i == 0) {
            return@forEachIndexed
        }
        print(" $v")
    }
    println()
}

fun buildMaxHeap(h: IntArray) {
    for (i in (h.size /2) downTo 1) {
        maxHeapify(h, i)
    }
}

fun maxHeapify(h: IntArray, i: Int) {
    val l = i * 2
    val r = i * 2 + 1
    var maxi = i
    if (l <= h.size - 1 && h[l] > h[i]) {
        maxi = l
    }
    if (r <= h.size - 1 && h[r] > h[maxi]) {
        maxi = r
    }
    if (maxi != i) {
        val tmp = h[i]
        h[i] = h[maxi]
        h[maxi] = tmp
        maxHeapify(h, maxi)
    }
}

//fun buildMaxHeap(h: IntArray) {
//    for (i in (h.size / 2) downTo 1) {
//        maxHeapify(h, i)
//    }
//}
//
//fun maxHeapify(h: IntArray, i: Int) {
//    val l = i * 2
//    val r = i * 2 + 1
//    var largest = i
//    if (l <= h.size - 1 && h[l] > h[i]) {
//        largest = l
//    }
//    if (r <= h.size - 1 && h[r] > h[largest]) {
//        largest = r
//    }
//    if (largest != i) {
//        val tmp = h[i]
//        h[i] = h[largest]
//        h[largest] = tmp
//        maxHeapify(h, largest)
//    }
//}
//
