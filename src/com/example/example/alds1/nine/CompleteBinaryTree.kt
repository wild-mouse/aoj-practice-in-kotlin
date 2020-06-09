package com.example.alds1.nine

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val h = IntArray(n + 1)
    for (i in 1..n) {
        h[i] = sc.nextInt()
    }
    h.forEachIndexed { i, v ->
        if (i == 0) {
            return@forEachIndexed
        }
        print("node $i: key = $v, ")
        if (i != 1) {
            print("parent key = ${h[i / 2]}, ")
        }
        if (h.size > i * 2) {
            print("left key = ${h[i * 2]}, ")
        }
        if (h.size > i * 2 + 1) {
            print("right key = ${h[i * 2 + 1]}, ")
        }
        println()
    }
}
