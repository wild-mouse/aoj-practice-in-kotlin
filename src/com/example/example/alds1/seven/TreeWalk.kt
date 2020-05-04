package com.example.alds1.seven

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        if (n < 1 || n > 25) {
            throw Exception("Illegal input")
        }
        val nodes = Array(n) { NodeForWalk() }
        for (i in 0 until n) {
            val id = sc.nextInt()
            val left = sc.nextInt()
            val right = sc.nextInt()
            nodes[id].left = left
            nodes[id].right = right
            if (left != -1) {
                nodes[left].parent = id
            }
            if (right != -1) {
                nodes[right].parent = id
            }
        }
        var rootId = -1
        for (i in 0 until n) {
            if (nodes[i].parent == -1) {
                rootId = i
            }
        }
        println("Preorder")
        walkPreorder(rootId, nodes)
        println()
        println("Inorder")
        walkInorder(rootId, nodes)
        println()
        println("Postorder")
        walkPostorder(rootId, nodes)
        println()
    } catch (e: Exception) {
        println(e)
    }
}

fun walkPreorder(id: Int, nodes: Array<NodeForWalk>) {
    print(" $id")
    if (nodes[id].left != -1) {
        walkPreorder(nodes[id].left, nodes)
    }
    if (nodes[id].right != -1) {
        walkPreorder(nodes[id].right, nodes)
    }
}

fun walkInorder(id: Int, nodes: Array<NodeForWalk>) {
    if (nodes[id].left != -1) {
        walkInorder(nodes[id].left, nodes)
    }
    print(" $id")
    if (nodes[id].right != -1) {
        walkInorder(nodes[id].right, nodes)
    }
}

fun walkPostorder(id: Int, nodes: Array<NodeForWalk>) {
    if (nodes[id].left != -1) {
        walkPostorder(nodes[id].left, nodes)
    }
    if (nodes[id].right != -1) {
        walkPostorder(nodes[id].right, nodes)
    }
    print(" $id")
}

class NodeForWalk(
        var parent: Int = -1,
        var left: Int = -1,
        var right: Int = -1
)
