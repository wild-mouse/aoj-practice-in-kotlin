package com.example.alds1.ten

import java.util.*

val ns: MutableList<Int> = MutableList(45) { -1 }

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val fn = getFibonacciNumber(n)
    println(fn)
}

fun getFibonacciNumber(n: Int): Int = calcFibonacciNumber(n)

fun calcFibonacciNumber(n: Int): Int {
    if (n < 0) {
        return 0;
    }
    if (n == 0 || n == 1) {
        return 1;
    }
    if (ns[n] != -1) {
        return ns[n]
    }
    val fn = calcFibonacciNumber(n - 1) + calcFibonacciNumber(n - 2)
    ns[n] = fn
    return fn
}
