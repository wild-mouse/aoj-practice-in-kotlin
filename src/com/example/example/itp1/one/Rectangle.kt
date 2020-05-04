package com.example.itp1.one

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    try {
        val a_b: Array<Int> = sc.nextLine().split(" ")
                .map{it.toInt()}
                .toTypedArray()
        val a = a_b[0]
        val b = a_b[1]
        val s = a * b
        val c = (a + b) * 2
        println(String.format("%d %d", s, c))
    } catch (e: Exception) {
        println(e)
    }
}
