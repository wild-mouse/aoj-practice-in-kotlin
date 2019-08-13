package com.example.alds1.ten

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 0 || n > 44) {
            throw Exception("Unexpected input.")
        }
//        val nn = fibonacciNumberOf(n)
        val nn= makeFibonacci(n)
        println(nn[n])
    } catch (e: Exception) {
        println(e)
    }
}

fun makeFibonacci(n: Int): IntArray {
    val fibonacciNumbers = IntArray(n+ 1)
    fibonacciNumbers[0] = 1
    fibonacciNumbers[1] = 1
    for (i in 2 .. n) {
        fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i -2]
    }
    return fibonacciNumbers
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