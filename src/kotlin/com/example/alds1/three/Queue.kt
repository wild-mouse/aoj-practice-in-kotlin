package com.example.alds1.three

import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val nQ = sc.nextLine()
            .split(" ")
            .map { Integer.parseInt(it) }
    val namesTimes = Queue()
    for (i in 0 until nQ[0]) {
        val nameTime = sc.nextLine().split(" ")
        namesTimes.enqueue(nameTime[0] to Integer.parseInt(nameTime[1]))
    }
    var processedTime = 0
    while (!namesTimes.isEmpty()) {
        var q = nQ[1]
        var nameTime = namesTimes.dequeue()
        if (nameTime!!.second > q) {
            processedTime += q
            nameTime = nameTime.first to nameTime.second.minus(q)
            namesTimes.enqueue(nameTime)
        } else {
            processedTime += nameTime.second
            q -= nameTime.second
            println("${nameTime.first} $processedTime")
        }
    }
}

class Queue {
    private val a = Array<Pair<String, Int>?>(100001) { null }

    private var head = 0

    private var tail = 0

    fun enqueue(v: Pair<String, Int>?) {
        a[tail] = v
        if (tail + 1 == a.size) {
            tail = 0
        } else {
            tail++
        }
    }

    fun dequeue(): Pair<String, Int>? {
        val r = a[head]
        a[head] = null
        if (head + 1 == a.size) {
            head = 0
        } else {
            head++
        }
        return r
    }

    fun isEmpty() = head == tail
}

