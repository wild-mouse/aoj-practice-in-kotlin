package com.example.example.alds1.nine

import java.util.*

var p = 0

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val h = IntArray(2_000_000)
    while (true) {
        val o_k = sc.nextLine().split(" ")
        if (o_k[0] == "end") {
            return
        }
        if (o_k[0] == "insert") {
            insert(h, Integer.parseInt(o_k[1]))
        }
        if (o_k[0] == "extract") {
            println(extractMax(h))
        }
    }
}

fun insert(h: IntArray, key: Int) {
    h[++p] = key
    buildMaxHeap(h, p)
}

fun buildMaxHeap(h: IntArray, p: Int) {
    for (i in (p / 2) downTo 1) {
        maxHeapify(h, i)
    }
}

fun maxHeapify(h: IntArray, i: Int) {
    val l = i * 2
    val r = i * 2 + 1
    var maxi = i
    if (l <= h.size - 1 && h[l] >= h[i]) {
        maxi = l
    }
    if (r <= h.size - 1 && h[r] >= h[maxi]) {
        maxi = r
    }
    if (i != maxi) {
        val tmp = h[i]
        h[i] = h[maxi]
        h[maxi] = tmp
        maxHeapify(h, maxi)
    }
}

fun extractMax(h: IntArray): Int {
    val extracted = h[1]
    h[1] = h[p]
    h[p] = 0
    buildMaxHeap(h, p)
    p--
    return extracted
}
