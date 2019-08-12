package com.example.alds1.nine

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val h = sc.nextInt()
        if (h > 250) {
            throw Exception("Illegal input")
        }
        val ks = IntArray(h + 1)
        for (i in 1..h) {
            ks[i] = sc.nextInt()
        }
        for (i in 1..h) {
            print("node $i: ")
            print("key = ${ks[i]}, ")
            if (i / 2 >= 1) {
                print("parent key = ${ks[i / 2]}, ")
            }
            if ((i * 2) < ks.size) {
                print("left key = ${ks[i*2]}, ")
            }
            if ((i * 2 + 1) < ks.size) {
                print("right key = ${ks[i*2+1]}, ")
            }
            println()
        }
    } catch (e: Exception) {
        println(e)
    }
}