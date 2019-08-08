package com.example.alds1.one

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
            println(gcd(a, b))
        } catch (e: Exception) {
            println(e)
        }

fun gcd(a: Int, b: Int): Int {
    val n = min(a, b)
    for (i in n downTo 1) {
        if (a % i == 0 && b % i == 0) {
            return i
        }
    }
    return 1
}
