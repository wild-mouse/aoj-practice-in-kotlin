package com.example.alds1.ten

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 0 || n > 44) {
            throw Exception("Unexpected input.")
        }
        val nn = fibonacciNumberOf(n)
        println(nn)
    } catch (e: Exception) {
        println(e)
    }
}

fun fibonacciNumberOf(n: Int, memo: IntArray = IntArray(n + 1)): Int {
    if (n == 0 || n == 1) {
        memo[n] = 1
        return memo[n]
    }
    if (memo[n] != 0) {
        return memo[n]
    }
    memo[n] = fibonacciNumberOf(n - 1, memo) + fibonacciNumberOf(n - 2, memo)
    return memo[n]
}