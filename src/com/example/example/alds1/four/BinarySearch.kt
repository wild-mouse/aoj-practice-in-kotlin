package com.example.alds1.four

import java.util.*

fun main(args: Array<String>) {
    try {

        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val s = sc.nextLine().split(" ").map { Integer.parseInt(it) }
        val q = Integer.parseInt(sc.nextLine())
        val t = sc.nextLine().split(" ").map { Integer.parseInt(it) }
        if (n > 100_000 || q > 50_000 || s.size > 1_000_000_000 || t.size > 1_000_000_000) {
            throw Exception("Illegal input.")
        }
        var c = 0
        val checked = mutableListOf<Int>()
        for (tt in t) {
            var left = 0
            var right = s.size
            while (left < right) {
                val mid: Int = (left + right) / 2
                if (s[mid] == tt) {
                    checked.add(tt)
                    c++
                    break
                } else if (tt < s[mid]) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }
        }
        println(c)
    } catch (e: Exception) {
        println(e)
    }
}