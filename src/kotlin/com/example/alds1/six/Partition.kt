package com.example.alds1.six

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 1 || n > 100_000) throw Exception("Illegal input")
        val a = IntArray(n)
        for (i in 0 until n) {
            a[i] = sc.nextInt()
            if (a[i] < 0 || a[i] > 100_000) throw Exception("Illegal input")
        }
        val sorted_i = partition(a, 0, a.size - 1)
        for (i in 0 until sorted_i.second) {
            print("${sorted_i.first[i]} ")
        }
        print("[${sorted_i.first[sorted_i.second]}]")
        for (i in sorted_i.second+1 until sorted_i.first.size) {
            print(" ${sorted_i.first[i]}")
        }
        println()
    } catch (e: Exception) {
        println(e)
    }
}

fun partition(a: IntArray, p: Int, r: Int): Pair<IntArray, Int> {
    val x = a[r]
    var i = p - 1
    for (j in p until r) {
        if (a[j] <= x) {
            i++
            val tmp = a[i]
            a[i] = a[j]
            a[j] = tmp
        }
    }
    val tmp = a[i + 1]
    a[i + 1] = a[r]
    a[r] = tmp
    return a to i + 1
}
