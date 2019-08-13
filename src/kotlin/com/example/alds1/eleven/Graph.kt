package com.example.alds1.eleven

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        if (n < 1 || n > 100) {
            throw Exception("Unexpected input.")
        }
        val a = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            val u = sc.nextInt()
            val k = sc.nextInt()
            for (j in 0 until k) {
                val v = sc.nextInt()
                a[u - 1][v - 1] = 1
            }
        }
        for (i in a.indices) {
            println(a[i].joinToString(" "))
        }
    } catch (e: Exception) {
        println(e)
    }
}