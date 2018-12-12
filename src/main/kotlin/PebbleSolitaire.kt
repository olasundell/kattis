import java.util.Scanner;

/**
 * TODO write documentation
 */
class PebbleSolitaire {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()
        val results = mutableListOf<Int>()

        for (i in 0 until n) {
            results.add(calcLine(scanner.nextLine()))
        }
        return results.joinToString(separator = "\n")
    }

    private fun calcLine(nextLine: String): Int {
        val state = state(nextLine)

        val leafs = mutableSetOf<Node>()
        val tree = buildTree(state, leafs)

        return leafs.toSortedSet().first().countPebbles()
    }

    private fun state(nextLine: String): State {
        val l = mutableListOf<Cavity>()
        for (c in nextLine.toCharArray()) {
            l.add(Cavity.from(c))
        }

        return State(l.toList())
    }

    private fun buildTree(state: State, leafs: MutableSet<Node>): Node {
        val moves = findMoves(state.cavities)
        val n = Node(state, moves.map { s -> buildTree(s, leafs) }.toSet())

        if (n.isLeaf()) {
            leafs.add(n)
        }

        return n
    }

    private fun findMoves(cavities: List<Cavity>): List<State> {
        val leftBefore = listOf(Cavity.EMPTY, Cavity.PEBBLE, Cavity.PEBBLE)
        val leftAfter = listOf(Cavity.PEBBLE, Cavity.EMPTY, Cavity.EMPTY)
        val rightBefore = listOf(Cavity.PEBBLE, Cavity.PEBBLE, Cavity.EMPTY)
        val rightAfter = listOf(Cavity.EMPTY, Cavity.EMPTY, Cavity.PEBBLE)
        val moves = mutableListOf<State>()

        for (i in 0 until cavities.size - 2) {
            val subList = cavities.subList(i, i + 3)
            if (subList == leftBefore) {
                moves.add(State(cavities.subList(0, i) + leftAfter + cavities.subList(i +3, cavities.size)))
            }
            if (subList == rightBefore) {
                moves.add(State(cavities.subList(0, i) + rightAfter + cavities.subList(i +3, cavities.size)))
            }
        }

        return moves.toList()
    }

    private fun depth(node: Node): Int {
        return 0
    }
}

data class Node(val state: State, val children: Set<Node>) : Comparable<Node> {
    fun countPebbles(): Int {
        return this.state.cavities.filter { cavity -> cavity == Cavity.PEBBLE }.count()
    }
    override fun compareTo(other: Node): Int {
        return this.countPebbles() - other.countPebbles()
    }

    fun isLeaf(): Boolean {
        return children.isEmpty()
    }
}

data class State(val cavities: List<Cavity>) {

}

enum class Cavity {
    NONE,
    EMPTY,
    PEBBLE;

    companion object {
        fun from(c: Char) : Cavity {
            return when (c) {
                '-' -> EMPTY
                'o' -> PEBBLE
                else -> NONE
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(PebbleSolitaire().solve(scanner))
}