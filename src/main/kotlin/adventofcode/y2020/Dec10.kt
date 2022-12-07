package adventofcode.y2020;

import java.lang.Integer.max
import java.lang.Integer.min
import java.lang.Math.pow
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToLong

/**
 * TODO write documentation
 */
class Dec10 {
    var runs = 0

    fun solve(scanner: Scanner): String {
        val queue = read(scanner)

        var one = 0
        var three = 1
        var now = 0

        while (queue.isNotEmpty()) {
            val c = queue.poll()
            if (c == now + 1) {
                one++
            } else if (c == now + 3) {
                three++
            }
            now = c
        }

        return "${one * three}"
    }

    fun solve2(scanner: Scanner): String {
        val list = read(scanner).toList().sorted()

        return "${part2(list.toIntArray())}"

//        var fours = 0
//        var threes = 0
//        var twos = 0
//        var i = 0
//
//        while (i < list.size) {
//            var inc = 0
//            for (j in 1..4) {
//                if (list[i] + j == list.getOrElse(i + j) { -2 }) {
//                    inc++
//                }
//            }
//
//            when (inc) {
//                4 -> fours++
//                3 -> threes++
//                2 -> twos++
//            }
//            i += max(( inc - 1), 1)
//        }
//
//        val d = 7.0.pow(fours) * 4.0.pow(threes) * 2.0.pow(twos)
//        return "${d.roundToLong()}"
    }

    private fun part2(list: IntArray): Long {
        val sums = LongArray(list[list.size - 1] + 1)
        sums[0] = 1
        for (i in list.indices) {
            val x = if (list[i] >= 3) sums[list[i] - 3] else 0
            val y = if (list[i] >= 2) sums[list[i] - 2] else 0
            val z = if (list[i] >= 1) sums[list[i] - 1] else 0
            sums[list[i]] = x + y + z
        }
        return sums[sums.size - 1]
    }

//    fun solve2(scanner: Scanner): String {
//        val queue = read(scanner)
//        queue.add(0)
//        queue.add(queue.max()!! + 3)
//        val arrange = arrange(0, queue.toList().sorted())
//        return "$arrange"
//        return "${findNum(queue.toList().sorted())}"
//    }

    private fun findNum(list: List<Int>): Long {
        val mult = mutableListOf<Long>()
        println(list)

        for (i in list.indices) {
            var currMult = 0L
            for (j in (i + 1 until min(i + 5 , list.size))) {
                if (list[j] - list[i] <= 3) {
                    currMult++
                }
            }
            mult.add(currMult)
        }

        mult[mult.size - 1] = 1

        return mult.reduce { acc, i -> acc * i }
    }

    private fun arrange(current: Int, queue: List<Int>): Long {
        runs++
        if (runs % 10_000 == 0) {
            println(runs)
        }
        if (queue.isEmpty()) {
            return 1
        }

        val alts = findAlts(current, queue)

        val sum = alts.map {
            if (it.isEmpty()) {
                1
            } else {
                arrange(it[0], it.subList(1, it.size))
            }
        }.sum()
        return sum
    }

    private fun findAlts(current: Int, queue: List<Int>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for (i in (0 until min(3, queue.size))) {
            if (queue[i] - current > 3) {
//                println(result.map { it.toList().sorted() } .joinToString(separator = ";"))
                return result
            }
            result.add((queue.subList(i, queue.size)))
        }

        return result
    }

    private fun read(scanner: Scanner): PriorityQueue<Int> {
        val queue = PriorityQueue<Int>()
        while (scanner.hasNextInt()) {
            queue.add(scanner.nextInt())
        }
        return queue
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec10().solve(scanner))
}