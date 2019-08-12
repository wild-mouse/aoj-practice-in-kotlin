package com.example.alds1.six

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 1 || n > 100_000) {
            throw Exception("Illegal input")
        }
        val a = Array(n) { "" to 0 }
        for (i in 0 until n) {
            a[i] = sc.next()!! to sc.nextInt()
            if (a[i].second < 1 || a[i].second > 1_000_000_000) {
                throw Exception("Illegal input")
            }
        }
        val quickSorted = quickSort(a.copyOf(), 0, a.size - 1)
        // TODO: replace with merge sort
        val bubbleSorted = bubbleSort(a.copyOf())
        if (isStable(bubbleSorted, quickSorted)) println("Stable") else println("Not stable")
        println(quickSorted.joinToString("\n") { "${it.first} ${it.second}" })
    } catch (e: Exception) {
        println(e)
    }
}

fun bubbleSort(a: Array<Pair<String, Int>>): Array<Pair<String, Int>> {
    var i = 0
    var isSorted = false
    while(!isSorted) {
        for (j in a.size - 1 downTo i + 1) {
            isSorted = true
            if (a[j].second < a[j - 1].second) {
                val tmp = a[j]
                a[j] = a[j - 1]
                a[j - 1] = tmp
                isSorted = false
            }
        }
        i++
    }
    return a
}

fun isStable(
        bubbleSorted: Array<Pair<String, Int>>,
        quickSorted: Array<Pair<String, Int>>
): Boolean {
    for (i in bubbleSorted.indices) {
        if (bubbleSorted[i].first != quickSorted[i].first
                || bubbleSorted[i].second != quickSorted[i].second) {
            return false
        }
    }
    return true
}

fun quickSort(a: Array<Pair<String, Int>>, p: Int, r: Int): Array<Pair<String, Int>> {
    if (p < r) {
        val sorted_i = partition(a, p, r)
        quickSort(sorted_i.first, p, sorted_i.second - 1)
        quickSort(sorted_i.first, sorted_i.second + 1, r)
    }
    return a
}

fun partition(
        a: Array<Pair<String, Int>>,
        p: Int,
        r: Int
): Pair<Array<Pair<String, Int>>, Int> {
    val x = a[r]
    var i = p - 1
    for (j in p until r) {
        if (a[j].second <= x.second) {
            i++
            val tmp = a[i]
            a[i] = a[j]
            a[j] = tmp
        }
    }
    val tmp = a[i + 1]
    a[i + 1] = a[r]
    a[r] = tmp
    return a to i + 1
}
