package adventofcode.y2018;

import java.lang.System.out
import java.util.*

/**
 * TODO write documentation
 */
class Dec12 {
    fun solve(scanner: Scanner): String {
        val pair = initialState(scanner)
        var pots: List<Char> = pair.first
        val set: Set<String> = pair.second

        var offset = -3
        val iterations = mutableListOf<Iteration>()

        var prevIter = Iteration(0, offset, pots)
        printOut(prevIter)

        for (i in 1..20) {
            val iteration = iterate(prevIter, set)
            offset = iteration.offset
            pots = iteration.pots
            printOut(iteration)
            iterations.add(iteration)
            prevIter = iteration
        }

        var sum = 0
        pots.forEachIndexed { index: Int, c: Char ->
            if (c == '#') {
                sum += (index + offset)
            }
        }

//        printOut(iterations)

        return sum.toString()
    }

    private fun printOut(iteration: Iteration) {
        out.println("${iteration.idx.toString().padStart(2, ' ')}: ${iteration.pots.joinToString("")} ${iteration.offset}")
    }

    private fun initialState(scanner: Scanner): Pair<List<Char>, Set<String>> {
        var pots = scanner.nextLine().split(": ")[1].toCharArray().toMutableList()

        pots.add(0, '.')
        pots.add(0, '.')
        pots.add(0, '.')

        scanner.nextLine()

        val set = mutableSetOf<String>()

        while (scanner.hasNextLine()) {
            set.add(scanner.nextLine().substring(0, 5))
        }

        while (pots[pots.size - 2] != '.' || pots[pots.size - 1] != '.') {
            pots.add('.')
        }

        return Pair(pots, set)
    }

    private fun iterate(iteration: Iteration, set: Set<String>): Iteration {
        val newPots = mutableListOf<Char>()
        var offset = iteration.offset

        for (i in 2 until iteration.pots.size - 2) {
            val element = iteration.pots.subList(i - 2, i + 3).joinToString("")
            if (set.contains(element)) {
                newPots.add('#')
            } else {
                newPots.add('.')
            }
        }

        offset += padStart(newPots)
        padEnd(newPots)

        return Iteration(iteration.idx + 1, offset, newPots.toList())
    }

    private fun padStart(newPots: MutableList<Char>): Int {
        var offset = 0
        newPots.add(0, '.')
        newPots.add(0, '.')
        while (newPots[0] != '.' || newPots[1] != '.' || newPots[2] != '.') {
            newPots.add(0, '.')
            offset--
        }
        return offset
    }

    private fun padEnd(newPots: MutableList<Char>) {
        while (newPots[newPots.size - 3] != '.' || newPots[newPots.size - 2] != '.' || newPots[newPots.size - 1] != '.') {
            newPots.add('.')
        }
    }

    data class Iteration(val idx: Int, val offset: Int, val pots: List<Char>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec12().solve(scanner))
}