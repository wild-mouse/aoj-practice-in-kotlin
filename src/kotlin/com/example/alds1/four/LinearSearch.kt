package com.example.alds1.four

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val s = sc.nextLine().split(" ").map { Integer.parseInt(it) }
                .toIntArray()
        val q = Integer.parseInt(sc.nextLine())
        val t = sc.nextLine().split(" ").map { Integer.parseInt(it) }
                .toIntArray()
        if (n > 10000 || q > 500 || s.size < 0 || s.size > 1_000_000_000 || t.size > 1_000_000_000) {
            throw Exception("Illegal input.")
        }
        var c = 0
        val checked = mutableListOf<Int>()
        for (tt in t) {
            if (checked.contains(tt)) continue
            for (ss in s) {
                if (ss == tt) {
                    c++
                    checked.add(tt)
                    break
                }
            }
        }
        println(c)
    } catch (e: Exception) {
        println(e)
    }
}