package com.example.alds1.one

import java.lang.Exception
import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val ns = sc.nextLine()
                .split(" ")
                .map { Integer.parseInt(it) }
                .toMutableList()
        if (n != ns.size || n < 1 || n > 100
                || ns.any { 0 > it && 1000 < it }
        ) {
            throw Exception("Illegal inputs.")
        }
        for (i in 0 until ns.size) {
            val v = ns[i]
            for (j in (i-1) downTo 0)  {
                if (ns[j] <= v) {
                    break
                }
                ns[j+1] = ns[j]
                ns[j] = v
            }
            println(ns.joinToString(" "))
        }
    } catch (e: Exception) {
        println(e)
    }
}