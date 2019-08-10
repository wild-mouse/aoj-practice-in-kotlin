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
        val sortedAAndCount: Pair<IntArray, Int> = selectionSort(a)
        println(sortedAAndCount.first.joinToString(" "))
        println(sortedAAndCount.second)
    } catch (e: Exception) {
        println(e)
    }
}
fun selectionSort(a: IntArray): Pair<IntArray, Int> {
    var c = 0
    for (i in 0 until a.size) {
        var minI = i
        for (j in i until a.size) {
            if (a[j] < a[minI]) {
                minI = j
            }
        }
        if (i == minI) continue
        val tmp = a[i]
        a[i] = a[minI]
        a[minI] = tmp
        c++
    }
    return a to c
}
