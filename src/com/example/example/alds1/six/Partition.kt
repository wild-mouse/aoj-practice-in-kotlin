package com.example.alds1.six

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = Integer.parseInt(sc.next())
    val a = IntArray(n).map { Integer.parseInt(sc.next()) }.toIntArray()
    val q = partition(a, 0, a.size - 1)
    a.forEachIndexed { index, i ->
        if (index == q) {
            print("[$i]")
        } else {
            print(i)
        }
        if (index != a.size - 1) {
            print(" ")
        }
    }
    println()
}

fun partition(a: IntArray, p: Int, r: Int): Int {
    val x = a[r]
    var i = p - 1
    for (j in p until r) {
        if (a[j] <= x) {
            i++
            val tmp = a[j]
            a[j] = a[i]
            a[i] = tmp
        }
    }
    val tmp = a[r]
    a[r] = a[i + 1]
    a[i + 1] = tmp
    return i + 1
}
