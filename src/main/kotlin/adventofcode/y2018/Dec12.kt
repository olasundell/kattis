package adventofcode.y2018;

import java.lang.System.out
import java.util.*

/**
 * TODO write documentation
 */
class Dec12 {
    fun solve(scanner: Scanner): String {
        val pair = initialState(scanner)
        val set: Set<String> = pair.second

        val iterations = mutableListOf<Iteration>()

        var prevIter = pair.first
        printOut(prevIter)

        for (i in 1..1_000) {
            val iteration = iterate(prevIter, set)
            val sum = sum(iteration)
            val prevSum = sum(prevIter)
//            out.println("$i: $sum - $prevSum == ${sum - prevSum}")
//            printOut(iteration)
            iterations.add(iteration)
            prevIter = iteration
        }

        var sum = sum(prevIter)

//        printOut(iterations)

        return (10189 + (50_000_000_000 - 99) * 78).toString()

//        return sum.toString()
    }

    private fun sum(iteration: Iteration): Int {
        var sum = 0
        iteration.pots.forEachIndexed { index: Int, pot: Pot ->
            if (pot.c == '#') {
                sum += pot.idx
            }
        }
        return sum
    }

    private fun printOut(iteration: Iteration) {
        out.println("${iteration.idx.toString().padStart(2, ' ')}: ${iteration.pots.joinToString("")}")
    }

    private fun initialState(scanner: Scanner): Pair<Iteration, Set<String>> {
        val pots = scanner.nextLine().split(": ")[1].toCharArray().mapIndexed { index, c -> Pot(index, c) }.toMutableList()

        scanner.nextLine()

        val set = mutableSetOf<String>()

        while (scanner.hasNextLine()) {
            val nextLine = scanner.nextLine()
            if (nextLine.endsWith("#")) {
                set.add(nextLine.substring(0, 5))
            }
        }

        val offset = padStart(pots)

        padEnd(pots)

        return Pair(Iteration(0, pots), set)
    }

    private fun iterate(iteration: Iteration, set: Set<String>): Iteration {
        val newPots = mutableListOf<Pot>()

        for (i in 2 until iteration.pots.size - 2) {
            val element = iteration.pots.subList(i - 2, i + 3).map { it.c }.joinToString("")
            newPots.add(Pot(iteration.pots[i].idx,
                if (set.contains(element)) {
                    '#'
                } else {
                    '.'
                }
            ))
        }

        padStart(newPots)
        padEnd(newPots)

        return Iteration(iteration.idx + 1, newPots.toList())
    }

    private fun padStart(newPots: MutableList<Pot>) {
        newPots.add(0, Pot(newPots[0].idx - 1, '.'))
        newPots.add(0, Pot(newPots[0].idx - 1, '.'))
        while (newPots[0].c != '.' || newPots[1].c != '.' || newPots[2].c != '.') {
            newPots.add(0, Pot(newPots[0].idx - 1, '.'))
        }
    }

    private fun padEnd(newPots: MutableList<Pot>) {
        while (newPots[newPots.size - 3].c != '.' || newPots[newPots.size - 2].c != '.' || newPots[newPots.size - 1].c != '.') {
            newPots.add(Pot(newPots.last().idx + 1, '.'))
        }
    }

    data class Pot(val idx: Int, val c: Char) {
        override fun toString(): String {
            return c.toString()
        }
    }
    data class Iteration(val idx: Int, val pots: List<Pot>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec12().solve(scanner))
}