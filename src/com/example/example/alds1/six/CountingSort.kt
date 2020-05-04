package com.example.alds1.six

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = Integer.parseInt(sc.next())
    val a = IntArray(n).map { Integer.parseInt(sc.next()) }.toIntArray()
    val b = countingSort(a)
    println(b.joinToString(" "))
}

fun countingSort(a: IntArray): IntArray {
    val c = IntArray(10000 + 1)
    a.forEach {
        c[it]++
    }
    for (i in 1 until c.size) {
        c[i] += c[i - 1]
    }
    val b = IntArray(a.size)
    a.forEach {
        b[c[it] - 1] = it
        c[it]--
    }
    return b
}

