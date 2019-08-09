package com.example.alds1.one

import java.util.Scanner

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        var c = 0
        for (i in 0 until n) {
            val a = sc.nextInt()
            if (a < 2 || a > 100_000_000) {
                throw Exception("Illegal input.")
            }
            if (isPrime(a)) c++
        }
        println(c)
    } catch (e: Exception) {
        println(e)
    }
}

fun isPrime(a: Int): Boolean {
    for (i in 2 until a) {
        if (a % i == 0) {
            return false
        }
    }
    return true
}
