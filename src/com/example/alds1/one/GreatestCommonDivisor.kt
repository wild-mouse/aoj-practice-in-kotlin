package com.example.alds1.one

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.Scanner

fun main(args: Array<String>) =
        try {
            val sc = Scanner(System.`in`)
            val a = sc.nextInt()
            val b = sc.nextInt()
            if (a < 1 || b < 1
                    || a > 1_000_000_000 || b > 1_000_000_000) {
                throw Exception("Illegal inputs.")
            }
            println(fastGcd(a, b))
        } catch (e: Exception) {
            println(e)
        }

fun fastGcd(a: Int, b: Int): Int {
    val x = max(a, b)
    val y = min(a, b)
    if ((x % y) == 0) {
        return y
    }
    return fastGcd(y, (x % y))
}

fun slowGcd(a: Int, b: Int): Int {
    val n = min(a, b)
    for (i in n downTo 1) {
        if (a % i == 0 && b % i == 0) {
            return i
        }
    }
    return 1
}
