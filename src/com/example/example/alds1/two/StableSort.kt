package com.example.alds1.two

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val a = sc.nextLine()
                .split(" ")
                .toTypedArray()
        if (n < 1 || n > 36 || n != a.size) throw Exception("Illegal input")
        val aBubbleSorted = bubbleSort(a.clone())
        val aSelectionSorted = selectionSort(a.clone())
        println(aBubbleSorted.joinToString(" "))
        println(isStable(a, aBubbleSorted))
        println(aSelectionSorted.joinToString(" "))
        println(isStable(a, aSelectionSorted))
    } catch (e: Exception) {
        println(e)
    }
}

fun isStable(original: Array<String>, sorted: Array<String>): String {
    val s = original.size
    for (i in 0 until s) {
        for (j in i + 1 until s) {
            for (a in 0 until s) {
                for (b in a + 1 until s) {
                    val ni = getN(original[i])
                    val nj = getN(original[j])
                    if (ni == nj && original[i] == sorted[b] && original[j] == sorted[a]) return "Not stable"
                }
            }
        }
    }
    return "Stable"
}

fun getN(card: String): Int = Integer.parseInt(card.substring(1))

fun bubbleSort(a: Array<String>): Array<String> {
    for (i in a.size downTo 0) {
        for (j in 1 until i) {
            if (getN(a[j - 1]) > getN(a[j])) {
                val tmp = a[j]
                a[j] = a[j - 1]
                a[j - 1] = tmp
            }
        }
    }
    return a
}

fun selectionSort(a: Array<String>): Array<String> {
    for (i in 0 until a.size) {
        var minJ = i
        for (j in i until a.size) {
            if (getN(a[j]) < getN(a[minJ])) {
                minJ = j
            }
        }
        if (i == minJ) continue
        val tmp = a[i]
        a[i] = a[minJ]
        a[minJ] = tmp
    }
    return a
}
