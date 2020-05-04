package com.example.alds1.nine

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val h = sc.nextInt()
        if (h < 1 || h > 500_000) {
            throw Exception("Illegal input")
        }
        val hs = IntArray(h + 1)
        for (i in 1..h) {
            hs[i] = sc.nextInt()
        }
        val heaped = buildMaxHeap(hs)
        for (i in 1 .. h) {
            print(" ${heaped[i]}")
        }
        println()
    } catch (e: Exception) {
        println(e)
    }
}

fun buildMaxHeap(hs: IntArray): IntArray {
    for (i in (hs.size - 1) / 2 downTo 1) {
         maxHeapify(hs, i)
    }
    return hs
}

fun maxHeapify(hs: IntArray, i: Int) {
    val l = i * 2
    val r = i * 2 + 1
    var largestI = i

    if (l < hs.size && hs[i] < hs[l]) {
        largestI = l
    }
    if (r < hs.size && hs[i] < hs[r] && hs[r] > hs[l]) {
        largestI = r
    }

    if (largestI != i) {
        val tmp = hs[i]
        hs[i] = hs[largestI]
        hs[largestI] = tmp
        maxHeapify(hs, largestI)
    }
}
