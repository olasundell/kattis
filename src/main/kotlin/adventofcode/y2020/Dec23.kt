package adventofcode.y2020;

import java.util.*

/**
 * The crab picks up the three cups that are immediately clockwise of the current cup.
 * They are removed from the circle; cup spacing is adjusted as necessary to maintain the circle.
 *
 * The crab selects a destination cup: the cup with a label equal to the current cup's label minus one.
 * If this would select one of the cups that was just picked up, the crab will keep subtracting one until it finds a cup that wasn't just picked up.
 * If at any point in this process the value goes below the lowest value on any cup's label, it wraps around to the highest value on any cup's label instead.
 *
 * The crab places the cups it just picked up so that they are immediately clockwise of the destination cup. They keep the same order as when they were picked up.
 *
 * The crab selects a new current cup: the cup which is immediately clockwise of the current cup.
 */
class Dec23(private val moves: Int) {
    fun solve(scanner: Scanner): String {
        val nextLine = scanner.nextLine()
        val queue = LinkedList<Int>(nextLine.toCharArray().map { it - '0' })

        var cIdx = 0

        (1..moves).forEach { i ->
            var nextC = queue[cIdx]
            val remove = calcRemove(cIdx, queue.size)

            while (remove.contains(nextC)) {
                nextC = (nextC + queue.size - 1) % queue.size
            }

            val removed = remove.map { queue.removeAt(it) }

            val newPlace = queue.indexOf(nextC)

            queue.addAll(newPlace, removed)

            cIdx = (cIdx + 1) % queue.size
        }

        return queue.joinToString(separator = "")
    }

    private fun calcRemove(cIdx: Int, size: Int): List<Int> {
        return (1..3).map { (cIdx + size + it) % size }.sortedDescending()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec23(10).solve(scanner))
}