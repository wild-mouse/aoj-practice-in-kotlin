package com.example.alds1.six

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = Integer.parseInt(sc.next())
    val cards = Array(n) { Pair(sc.next()[0], Integer.parseInt(sc.next())) }
    val sortedCards = quickSort(cards)
    if (isStable(cards.copyOf(), sortedCards.copyOf())) {
        println("Stable")
    } else {
        println("Not stable")
    }
    println(sortedCards.joinToString("\n") { it.first + " " + it.second })
}

fun quickSort(c: Array<Pair<Char, Int>>): Array<Pair<Char, Int>> {
    val sortedC = c.copyOf()
    doQuicksort(sortedC, 0, c.size - 1)
    return sortedC
}

fun doQuicksort(c: Array<Pair<Char, Int>>, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    val mid = partition(c, l, r)
    doQuicksort(c, 0, mid - 1)
    doQuicksort(c, mid + 1, r)
}

fun partition(c: Array<Pair<Char, Int>>, l: Int, r: Int): Int {
    val x = c[r]
    var i = l - 1
    for (j in l until r) {
        if (x.second >= c[j].second) {
            i++
            val tmp = c[i]
            c[i] = c[j]
            c[j] = tmp
        }
    }
    val tmp = c[r]
    c[r] = c[i + 1]
    c[i + 1] = tmp
    return i + 1
}

fun isStable(c1: Array<Pair<Char, Int>>, c2: Array<Pair<Char, Int>>): Boolean {
    c1.forEach { card1 ->
        val i = c2.indexOfFirst { card2 -> card1.second == card2.second }
        if (c2[i].first != card1.first) {
            return false
        }
        c2[i] = Pair(' ', -1)
    }
    return true
}
