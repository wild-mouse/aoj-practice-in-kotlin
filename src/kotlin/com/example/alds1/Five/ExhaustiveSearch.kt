package com.example.alds1.Five

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val a = sc.nextLine().split(" ").map { Integer.parseInt(it) }
        val q = Integer.parseInt(sc.nextLine())
        val m = sc.nextLine().split(" ").map { Integer.parseInt(it) }
        if (n > 20 || q > 200 || n != a.size || q != m.size ||
                a.size < 1 || a.size > 2000 || m.size < 1 || m.size > 2000) {
            throw Exception("Illegal input")
        }
        val c = getCombination(a)
        for (mm in m) {
            if (c.contains(mm)) println("yes")
            else println("no")
        }
    } catch (e: Exception) {
        println(e)
    }
}

fun getCombination(
        a: List<Int>,
        i: Int = 0,
        v: Int = 0,
        c: MutableList<Int> = mutableListOf()
): List<Int> {
    if (i == a.size) {
        c.add(v)
        return c
    }
    val v1 = a[i]
    getCombination(a, i + 1, v, c)
    getCombination(a, i + 1, v + v1, c)
    return c
}
