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
        val r = depthFirstSearch(a)
        for (i in r.indices) {
            println("${i + 1} ${r[i][0]} ${r[i][1]}")
        }
    } catch (e: Exception) {
        println(e)
    }
}

// TODO: This algorithm is incorrect.
fun depthFirstSearch(
        a: Array<IntArray>
): Array<IntArray> {
    val r = Array(a.size) { IntArray(2) }
    val stack = Stack<Int>()
    var t = 1
    stack.push(0)
    r[0][0] = 1
    while (!stack.empty()) {
        val current = stack.peek()
        val next = a[current].indexOfFirst { it != 0 }
        if (next != -1) {
            a[current][next] = 0
            stack.push(next)
            r[next][0] = ++t
        } else {
            val searched = stack.pop()
            r[searched][1] = ++t
        }
    }
    return r
}
