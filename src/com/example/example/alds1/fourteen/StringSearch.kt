package com.example.alds1.ten

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val t = sc.next()
    val p = sc.next()

    kmp(p, t)
}

private fun kmp(t: String, p: String) {
    val h = getTable(p)

    var i = 0
    while (i <= t.length - p.length) {
        var match = true
        var offset = 0
        for (j in 0 until p.length) {
            if (t[i + j] != p[j]) {
                match = false
                offset = h[j]
                break
            }
        }
        if (match) {
            println(i)
        }
        if (offset > 0) {
            i += offset
        }
        i++
    }
}

fun getTable(p: String): IntArray {
    val m = p.length
    val fail = IntArray(m)
    var j = 1
    var k = 0
    while (j < m) {
        if (p[j] == p[k]) {
            fail[j] = k + 1
            j++
            k++
        } else if (k > 0) {
            k = fail[k - 1]
        } else {
            j++
        }
    }
    return fail
}
