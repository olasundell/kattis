package adventofcode.y2020

import java.util.Scanner
import java.util.concurrent.LinkedBlockingDeque

/**
 * TODO write documentation
 */
class Dec9(private val preamble: Int) {
    fun solve(scanner: Scanner): String {
        val queue = LinkedBlockingDeque<Long>(preamble)
        for (i in 0 until preamble) {
            queue.add(scanner.nextLong())
        }

        while (scanner.hasNextLong()) {
            val prevSums = calcPreviousSums(queue)
            val c = scanner.nextLong()
            if (!prevSums.contains(c)) {
                return c.toString()
            }

            queue.poll()
            queue.put(c)
        }

        return "-1"
    }

    fun solve2(scanner: Scanner): String {
        val queue = LinkedBlockingDeque<Long>(preamble)
        val allNumbers = mutableListOf<Long>()
        for (i in 0 until preamble) {
            queue.add(scanner.nextLong())
            allNumbers.add(queue.last)
        }

        while (scanner.hasNextLong()) {
            val prevSums = calcPreviousSums(queue)
            val c = scanner.nextLong()
            allNumbers.add(c)

            if (!prevSums.contains(c)) {
//                try {
//                    adders(allNumbers.map { Sum(it, listOf(it)) }, c)
//                } catch (e: FoundTarget) {
//                    return e.message!!
//                }
                return calculateAnswer(allNumbers, c)
            }

            queue.poll()
            queue.put(c)
        }

        return "-1"
    }

    private fun calculateAnswer(list: List<Long>, target: Long): String {
        var additions = 0
        for (n in 2 until list.size) {
            for (i in 0..(list.size - n)) {
                var sum = 0L
                for (j in 0 until n) {
                    sum += list[i + j]
                    additions++
                    if (sum > target) {
                        break
                    }
                }
                if (sum == target) {
                    println(additions)
                    return maxMinAdded(list.subList(i, i + n))
                }
            }
        }
        return "-1"
    }

//    private fun adders(list: List<Sum>, target: Long): List<Sum> {
//        if (list.size == 1) {
//            return list
//        }
//
//        println(list.joinToString(separator = ", "))
//
//        val result = mutableListOf<Sum>()
//
//        for (i in 0 until list.size - 1) {
//            val element = list[i] + list[i + 1]
//            if (element.sum == target) {
//                throw FoundTarget(maxMinAdded(element.parts))
//            }
//            result.add(element)
//        }
//
//        return adders(result, target)
//    }

    operator fun Sum.plus(sum: Sum) = Sum(this.sum + sum.sum, this.parts + sum.parts)
    data class Sum(val sum: Long, val parts: List<Long>)

    private fun maxMinAdded(list: List<Long>): String {
        return "${list.maxOrNull()!! + list.minOrNull()!!}"
    }

    private fun calcPreviousSums(queue: LinkedBlockingDeque<Long>): Set<Long> {
        val set = mutableSetOf<Long>()
        for (i in queue.indices) {
            for (j in i until queue.size) {
                set.add(queue.elementAt(i) + queue.elementAt(j))
            }
        }

        return set
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println(Dec9(25).solve(scanner))
}