package com.example.alds1.one

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.nextInt()
    }
    println(a.joinToString(" "))
    insertionSort(a)
}

fun insertionSort(a: IntArray) {
    for (i in 1 until a.size) {
        val v = a[i]
        var ti = i
        for (j in i - 1 downTo 0) {
            if (v < a[j]) {
                a[j + 1] = a[j]
                ti = j
            }
        }
        a[ti] = v
        println(a.joinToString(" "))
    }
}
