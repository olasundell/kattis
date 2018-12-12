package adventofcode.y2018;

import java.util.*

class Dec8 {
    fun solve(scanner: Scanner): String {
        val root = readNode(scanner)

        return calcMetaSum(root).toString()
    }

    private fun calcMetaSum(node: Node): Int {
        return node.children.map { calcMetaSum(it) }.sum() + node.metadata.sum()
    }

    private fun readNode(scanner: Scanner): Node {
        val noOfChildren = scanner.nextInt()
        val noOfMeta = scanner.nextInt()
        val children = mutableListOf<Node>()
        val metadata = mutableListOf<Int>()

        for (i in 0 until noOfChildren) {
            children.add(readNode(scanner))
        }

        for (i in 0 until noOfMeta) {
            metadata.add(scanner.nextInt())
        }

        return Node(children, metadata)
    }

    fun solve2(scanner: Scanner): String {
        val root = readNode(scanner)

        return calcStrangeMetaSum(root).toString()
    }


    private fun calcStrangeMetaSum(node: Node): Int {
        if (node.children.isEmpty()) {
            return node.metadata.sum()
        } else {
            var sum = 0
            for (idx in node.metadata.map { it - 1 }) {
                if (idx < node.children.size) {
                    sum += calcStrangeMetaSum(node.children[idx])
                }
            }

            return sum
        }
    }

    data class Node(val children: List<Node>, val metadata: List<Int>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec8().solve(scanner))
}