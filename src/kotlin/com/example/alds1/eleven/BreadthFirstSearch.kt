package com.example.alds1.eleven

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 1 || n > 100) {
            throw Exception("Unexpected input.")
        }
        val a = Array<IntArray>(n) { IntArray(n) }
        for (i in 0 until n) {
            val u = sc.nextInt()
            val k = sc.nextInt()
            for (j in 0 until k) {
                val v = sc.nextInt()
                a[u - 1][v - 1] = 1
            }
        }
//        for (i in a.indices) {
//            println(a[i].joinToString(" "))
//        }
        val d = BFS(a)
        for (i in d.indices) {
            println("${i + 1} ${d[i]}")
        }
    } catch (e: Exception) {
        println(e)
    }
}

fun BFS(a: Array<IntArray>): IntArray {
    val d = IntArray(a.size) { -1 }
    val q = LinkedList<Int>()
    val v = IntArray(a.size)
    d[0] = 0
    v[0] = 1
    q.add(0)
    while (!q.isEmpty()) {
        val c = q.removeFirst()
        for (i in a.indices) {
            if (a[c][i] == 1 && v[i] == 0) {
                v[i] = 1
                q.addLast(i)
                d[i] = d[c] + 1
            }
        }
    }
    return d
}