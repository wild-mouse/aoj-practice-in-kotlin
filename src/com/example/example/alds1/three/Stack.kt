package com.example.alds1.three

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val s = sc.nextLine().split(" ")
        val stack = Stack()
        s.forEach {
            when (it) {
                "+" -> stack.push(stack.pop() + stack.pop())
                "-" -> {
                    val a = stack.pop()
                    val b = stack.pop()
                    stack.push(b - a)
                }
                "*" -> stack.push(stack.pop() * stack.pop())
                else -> stack.push(Integer.parseInt(it))
            }
        }
        println(stack.pop())
    } catch (e: Exception) {
        println(e)
    }
}

class Stack {
    private val s = mutableListOf<Int>()

    private var top = s.size - 1

    fun push(x: Int) {
        s.add(x)
        top = s.size - 1
    }

    fun pop(): Int {
        if (isEmpty()) {
            throw Exception("Stack is empty.")
        }
        return s.removeAt(top--)
    }

    fun isEmpty(): Boolean = s.size == 0
}
