package com.example.itp1.two

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    try {
        val a = sc.nextInt()
        val b = sc.nextInt()
        when {
            a < b -> println("a < b")
            a > b -> println("a > b")
            else -> println("a == b")
        }
    } catch (e: Exception) {
        println(e)
    }
}