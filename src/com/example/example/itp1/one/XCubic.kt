package com.example.itp1.one

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    try {
        val x = sc.nextInt()
        println(x * x * x)
    } catch (e: Exception) {
        println(e)
    }
}
