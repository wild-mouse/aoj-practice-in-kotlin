package com.example.alds1.eight

import java.util.*

fun main(args:  Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val tree = TreeForI()
        for (i in 0 until n) {
            var key: Int?
            val instruction = sc.next()!!
            if (instruction == "insert") {
                key = sc.nextInt()
                tree.insert(NodeForI(key = key))
            }
            if (instruction == "print") {
                tree.printInorder(tree.root)
                println()
                tree.printPreorder(tree.root)
                println()
            }
        }
    } catch( e: Exception) {
        println(e)
    }
}

class TreeForI(
        var root: NodeForI? = null
) {
    fun insert(newNode: NodeForI) {
        var currentNode: NodeForI? = null
        var nodeParent = root
        while (nodeParent != null) {
            currentNode = nodeParent
            if (newNode.key < nodeParent.key) {
                nodeParent = nodeParent.left
            } else {
                nodeParent = nodeParent.right
            }
        }

        newNode.parent = currentNode
        if (currentNode == null) {
            root = newNode
        } else if (newNode.key < currentNode.key) {
            currentNode.left = newNode
        } else {
            currentNode.right = newNode
        }
    }

    fun printPreorder(node: NodeForI?) {
        if (node == null) return
        print(" ${node.key}")
        printPreorder(node.left)
        printPreorder(node.right)
    }

    fun printInorder(node: NodeForI?) {
        if (node == null) return
        printInorder(node.left)
        print(" ${node.key}")
        printInorder(node.right)
    }
}

class NodeForI(
        var parent: NodeForI? = null,
        var left: NodeForI? = null,
        var right: NodeForI? = null,
        var key: Int = 0
)

