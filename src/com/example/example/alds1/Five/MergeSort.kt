package com.example.alds1.Five

import java.util.*

var count = 0

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = Integer.parseInt(sc.next())
    val s = IntArray(n)
    for (i in 0 until n) {
        s[i] = Integer.parseInt(sc.next())
    }
    mergeSort(s, 0, s.size)
    for (i in 0 until s.size) {
        print(s[i])
        if (i < s.size - 1) {
            print(" ")
        }
    }
    println()
    println(count)
}

fun mergeSort(s: IntArray, left: Int, right: Int) {
    if (left + 1 >= right) {
        return
    }
    val mid = (left + right) / 2
    mergeSort(s, left, mid)
    mergeSort(s, mid, right)
    merge(s, left, right)
}

fun merge(s: IntArray, left: Int, right: Int) {
    val mid = (left + right) / 2
    val leftA = s.toList().subList(left, mid).toIntArray()
    val rightA = s.toList().subList(mid, right).toIntArray()
    var i = 0
    var j = 0
    for (k in left until right) {
        count++
        if (i >= leftA.size) {
            s[k] = rightA[j++]
            continue
        }
        if (j >= rightA.size) {
            s[k] = leftA[i++]
            continue
        }
        if (leftA[i] > rightA[j]) {
            s[k] = rightA[j++]
        } else {
            s[k] = leftA[i++]
        }
    }
}


