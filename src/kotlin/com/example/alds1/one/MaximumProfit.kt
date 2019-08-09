package com.example.alds1.one

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 2 || n > 200_000) {
            throw Exception("Illegal input.")
        }
        val rs = IntArray(n)
        for (i in 0 until n) {
            rs[i] = sc.nextInt()
            if (rs[i] < 0 || rs[i] > 1_000_000_000) {
                throw Exception("Illegal input.")
            }
        }
        val m = getMaximumProfit(rs)
        println(m)
    } catch (e: Exception) {
        println(e)
    }
}

fun getMaximumProfit(rs: IntArray): Int {
    var r = -1_000_000_000
    for (i in 0 until rs.size) {
        for (j in i + 1 until rs.size) {
            if (rs[j] - rs[i] > r) {
                r = rs[j] - rs[i]
            }
        }
    }
    return r
}