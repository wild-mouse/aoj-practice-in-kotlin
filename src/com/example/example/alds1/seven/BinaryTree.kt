package com.example.alds1.seven

import java.util.*

fun main(args: Array<String>) {
    try {
        val sc = Scanner(System.`in`)
        val n = sc.nextInt()
        val nodes = Array(n) { BinaryNode() }
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
        for (i in nodes.indices) {
            if (nodes[i].parent == -1) {
                rootId = i
            }
        }
        val hs = IntArray(n) { -1 }
        setHeights(rootId, hs, nodes)
        val ds = IntArray(n) { -1 }
        setDepths(rootId, ds, nodes, 0)

        for (i in 0 until n) {
            val node = nodes[i]
            val sibling = when {
                node.parent == -1 -> -1
                nodes[node.parent].left == i -> nodes[node.parent].right
                else -> nodes[node.parent].left
            }
            val type =
                    if (node.parent == -1) "root"
                    else if (node.left != -1 || node.right != -1) "internal node"
                    else "leaf"
            var degree = 0
            if (node.left != -1) ++degree
            if (node.right != -1) ++degree
            println("node $i: parent = ${node.parent}, " +
                    "sibling = $sibling, degree = $degree, " +
                    "depth = ${ds[i]}, height = ${hs[i]}, $type")
        }
    } catch (e: Exception) {
        println(e)
    }
}

fun setHeights(id: Int, hs: IntArray, nodes: Array<BinaryNode>): Int {
    var h1 = 0
    var h2 = 0
    if (nodes[id].left != -1) {
        h1 = setHeights(nodes[id].left, hs, nodes) + 1
    }
    if (nodes[id].right != -1) {
        h2 = setHeights(nodes[id].right, hs, nodes) + 1
    }
    hs[id] = Math.max(h1, h2)
    return hs[id]
}

fun setDepths(id: Int, ds: IntArray, nodes: Array<BinaryNode>, d: Int): IntArray {
    if (id == -1) return ds
    ds[id] = d
    setDepths(nodes[id].left, ds, nodes, d + 1)
    setDepths(nodes[id].right, ds, nodes, d + 1)
    return ds
}

class BinaryNode(
        var parent: Int = -1,
        var left: Int = -1,
        var right: Int = -1
)

