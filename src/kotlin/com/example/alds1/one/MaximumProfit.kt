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
        val m = getMaximumProfitFast(rs)
        println(m)
    } catch (e: Exception) {
        println(e)
    }
}

fun getMaximumProfitFast(rs: IntArray): Int {
    var r = -1_000_000_000
    var rMin = rs[0]
    for (i in 1 until rs.size) {
        if (r < rs[i] - rMin) {
            r = rs[i] - rMin
        }
        if (rs[i] < rMin) rMin = rs[i]
    }
    return r
}

fun getMaximumProfitSlow(rs: IntArray): Int {
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