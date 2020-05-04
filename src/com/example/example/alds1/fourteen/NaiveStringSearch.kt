package com.example.alds1.ten

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.next()
    val p = sc.next()
    for (i in 0..t.length - p.length) {
        if (t.subSequence(i, i + p.length) == p) {
            println(i)
        }
    }
}
