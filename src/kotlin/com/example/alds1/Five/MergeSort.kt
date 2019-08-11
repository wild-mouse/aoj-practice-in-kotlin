package com.example.alds1.Five

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val s = IntArray(n)
        for (i in 0 until n) {
            s[i] = sc.nextInt()
        }
        if (n > 500_000 || s.size > 1_000_000_000 || n != s.size) {
            throw Exception("Illegal input")
        }
        val c = mergeSort(s, 0, s.size)
        println(s.joinToString(" "))
        println(c)
    } catch (e: Exception) {
        println(e)
    }
}

fun mergeSort(a: IntArray, left: Int, right: Int): Int {
    var c = 0
    if (left + 1 < right) {
        val mid = (left + right) / 2
        c += mergeSort(a, left, mid)
        c += mergeSort(a, mid, right)
        c += merge(a, left, mid, right)
    }
    return c
}

fun merge(a: IntArray, left: Int, mid: Int, right: Int): Int {
    val n1 = mid - left
    val n2 = right - mid
    val l = IntArray(n1)
    val r = IntArray(n2)
    for (i in 0 until n1) {
        l[i] = a[left + i]
    }
    for (i in 0 until n2) {
        r[i] = a[mid + i]
    }
    var i = 0
    var j = 0
    var c = 0
    for (k in left until right) {
        if (j >= r.size || (i < l.size && l[i] <= r[j])) {
            a[k] = l[i++]
        } else {
            a[k] = r[j++]
        }
        c++
    }
    return c
}
