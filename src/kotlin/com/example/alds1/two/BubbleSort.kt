package com.example.alds1.two

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.nextInt()
    }
    bubbleSort(a)
}

fun bubbleSort(a: IntArray) {
    var c = 0
    for (i in a.size - 1 downTo 0) {
        for (j in 1..i) {
            if (a[j - 1] > a[j]) {
                val tmp = a[j]
                a[j] = a[j - 1]
                a[j - 1] = tmp
                c++
            }
        }
    }
    println(a.joinToString(" "))
    println(c)
}

