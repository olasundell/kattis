package kattis

import java.util.*
import kotlin.math.pow

/**
 * TODO write documentation
 */
class OwlAndFox {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val queue = mutableListOf<Value>()

        repeat(n) {
            val nextInt = scanner.nextInt()
            val c = nextInt.toString().map { (it - '0') }
            val sum = c.sum()
            queue.add(Value(c, sum, nextInt, findLesser(c, sum, nextInt)))
        }

        return queue.joinToString(separator = "\n") { it.lesser.toString() }
    }

    private fun findLesser(c: List<Int>, sum: Int, nextInt: Int): Int {
        if (sum == 1) {
            return 0
        } else {
            val r = c.toMutableList()
            for (i in r.size - 1 downTo 0) {
                if (r[i] != 0) {
                    r[i] = r[i] - 1

                    return r.foldRightIndexed(0) { index, cur, acc -> act(index, cur, acc, r.size) }
                }
            }
        }

        return -1
    }

    private fun act(index: Int, cur: Int, acc: Int, size: Int): Int {
        val i1 = size - index - 1
        val pow = 10.0.pow(i1).toInt()
        val i = cur * pow
        return (acc + i)
    }

    data class Value(val n: List<Int>, val sum: Int, val actual: Int, val lesser: Int)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(OwlAndFox().solve(scanner))
}