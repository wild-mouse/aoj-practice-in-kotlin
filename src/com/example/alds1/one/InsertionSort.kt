package com.example.alds1.one

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    try {
        val n = sc.nextInt()
        val a = IntArray(n)
        for (i in 0 until n) {
            a[i] = sc.nextInt()
        }
        println(a.joinToString(" "))
        for (i in 1 until a.size) {
            val v = a[i]
            var j = i - 1
            while (j >= 0 && a[j] > v) {
                a[j + 1] = a[j]
                j--
            }
            a[j+1] = v
            println(a.joinToString(" "))
        }
    } catch (e: Exception) {
        println(e)
    }
}