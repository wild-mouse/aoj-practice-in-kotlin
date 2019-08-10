package com.example.alds1.two

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        if (n < 1 || n > 100) {
            throw Exception("Illegal input.")
        }
        val a = sc.nextLine()
                .split(" ")
                .map { Integer.parseInt(it) }
                .toIntArray()
        val sortedAAndTime: Pair<IntArray, Int> = bubbleSort(a)
        println(sortedAAndTime.first.joinToString(" "))
        println(sortedAAndTime.second)
    } catch (e: Exception) {
        println(e)
    }
}

fun bubbleSort(a: IntArray): Pair<IntArray, Int> {
    var c = 0
    var i = a.size
    var isSorted = false
    while (!isSorted) {
        isSorted = true
        for (j in 1 until i) {
            if (a[j - 1] > a[j]) {
                val tmp = a[j]
                a[j] = a[j - 1]
                a[j - 1] = tmp
                isSorted = false
                c++
            }
        }
        i--
    }
    return a to c
}