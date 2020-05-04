package com.example.alds1.Five

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n).map { sc.nextInt() }.toIntArray()
    val q = sc.nextInt()
    for (i in 0 until q) {
        if (combination(a, sc.nextInt())) {
            println("yes")
        } else {
            println("no")
        }
    }
}

fun combination(a: IntArray, m: Int, i: Int = 0): Boolean {
    if (m == 0) {
        return true
    }
    if (i >= a.size) {
        return false
    }

    return combination(a, m, i + 1) || combination(a, m - a[i], i + 1)
}
