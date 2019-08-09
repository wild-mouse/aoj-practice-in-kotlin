package com.example.itp1.one

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val S: Int = Integer.parseInt(sc.nextLine())
    val h = S / (60 * 60)
    var remainingS = S % (60 * 60)
    val m = remainingS / 60
    remainingS %= 60
    val s = remainingS
    println(String.format("%d:%d:%d", h, m, s))
}
