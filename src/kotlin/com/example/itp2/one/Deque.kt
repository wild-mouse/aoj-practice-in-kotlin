package com.example.itp2.one

import java.util.*

// TODO: This solution is slow.
fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val q = sc.nextInt()
        if (q < 1 || q > 400000) {
            throw Exception("Unexpected input.")
        }
        val deque = ArrayDeque<Int>()
        for (i in 0 until q) {
            val instruction = sc.nextInt()
            if (instruction == 0) {
                val d = sc.nextInt()
                val x = sc.nextInt()
                if (d == 0) {
                    deque.addFirst(x)
                } else {
                    deque.addLast(x)
                }
            }
            if (instruction == 1) {
                val p = sc.nextInt()
                println(deque.elementAt(p))
            }
            if (instruction == 2) {
                val d = sc.nextInt()
                if (d == 0) {
                    deque.removeFirst()
                } else {
                    deque.removeLast()
                }
            }
        }
    } catch (e: Exception) {
        println(e)
    }
}