package com.example.itp2.one

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val q = sc.nextInt()
        if (q < 1 || q > 200000) {
            throw Exception("Unexpected input.")
        }
        val v = ArrayList<Int>()
        for (i in 0 until q) {
            val instruction = sc.nextInt()
            if (instruction == 0) {
                val x = sc.nextInt()
                v.add(x)
            }
            if (instruction == 1) {
                val p = sc.nextInt()
                println(v.get(p))
            }
            if (instruction == 2) {
                v.removeAt(v.lastIndex)
            }
        }
    } catch (e: Exception) {
        println(e)
    }
}

// This is too slow.
class Vector {
    private var v = IntArray(0)

    fun pushBack(x: Int) {
        val newV = v.copyOf(v.size + 1)

        newV[newV.lastIndex] = x
        v = newV
    }

    fun randomAccess(p: Int): Int {
        return v[p]
    }

    fun popBack() {
        v = v.copyOf(v.size - 1)
    }
}