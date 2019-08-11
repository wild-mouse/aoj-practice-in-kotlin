package com.example.alds1.four

import java.util.*

// TODO: Not resolved.
fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = Integer.parseInt(sc.nextLine())
        val d = Dictionary()
        for (i in 0 until n) {
            val c_s = sc.nextLine().split(" ")
            if (c_s[0] == "insert") {
                d.insert(c_s[1])
            }
            if (c_s[0] == "find") {
                println(d.find(c_s[1]))
            }
        }
    } catch (e: Exception) {
        println(e)
    }
}

class Dictionary{
    private val a = mutableListOf<String>()

    fun insert(s: String) {
        if (a.contains(s)) return
        a.add(s)
    }

    fun find(s: String) = if (a.contains(s)) "yes" else "no"
}