package com.example.alds1.six

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 1 || n > 2_000_000) {
            throw Exception("Illegal input")
        }
        val a = IntArray(n)
        for (i in 0 until n) {
            a[i] = sc.nextInt()
            if (a[i] < 0 || a[i] > 10000) {
                throw Exception("Illegal input")
            }
        }
        val maxv = 10001
        val c = IntArray(maxv)
        for (i in 0 until n) {
            c[a[i]]++
        }
        for (i in 1 until maxv) {
            c[i] = c[i] + c[i-1]
        }
        val b = IntArray(n)
        for (j in n downTo 1) {
            b[c[a[j- 1]] - 1] = a[j-1]
            c[a[j-1]]--
        }
        println(b.joinToString(" "))
    } catch(e: Exception) {
        println(e)
    }
}
