package com.example.alds1.eight

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n > 500_000) {
            throw Exception("Illegal input")
        }
        val tree = TreeII()
        for (i in 0 until n) {
            val instruction = sc.next()!!
            if (instruction == "insert") {
                val key = sc.nextInt()
                tree.insert(NodeII(key = key))
            }
            if (instruction == "find") {
                val key = sc.nextInt()
                if (tree.find(key, tree.root)) {
                    println("yes")
                } else {
                    println("no")
                }
            }
            if (instruction == "print") {
                tree.printInorder(tree.root)
                println()
                tree.printPreorder(tree.root)
                println()
            }
        }
    } catch (e: Exception) {
        println(e)
    }
}

class TreeII {
    var root: NodeII? = null

    fun insert(newNode: NodeII) {
        var parentNode: NodeII? = null
        var currentNode: NodeII? = root
        while (currentNode != null) {
            parentNode = currentNode
            if (newNode.key < currentNode.key) {
                currentNode = currentNode.left
            } else {
                currentNode = currentNode.right
            }
        }

        newNode.parent = parentNode
        if (newNode.parent == null) {
            root = newNode
        } else if (newNode.key < parentNode!!.key) {
            parentNode.left = newNode
        } else {
            parentNode.right = newNode
        }
    }

    fun find(key: Int, node: NodeII?): Boolean {
        if (node == null) return false
        if (node.key == key) {
            return true
        }
        if (key < node.key) {
            return find(key, node.left)
        }
        if (key > node.key) {
            return find(key, node.right)
        }
        return false
    }

    fun printPreorder(node: NodeII?) {
        if (node == null) return
        print(" ${node.key}")
        printPreorder(node.left)
        printPreorder(node.right)
    }

    fun printInorder(node: NodeII?) {
        if (node == null) return
        printInorder(node.left)
        print(" ${node.key}")
        printInorder(node.right)
    }
}

class NodeII(
        var parent: NodeII? = null,
        var left: NodeII? = null,
        var right: NodeII? = null,
        var key: Int
)