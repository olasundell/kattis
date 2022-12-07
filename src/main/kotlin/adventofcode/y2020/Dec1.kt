package adventofcode.y2020;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec1 {
    fun solve(scanner: Scanner): String {
        val ints = mutableListOf<Int>()

        while (scanner.hasNextInt()) {
            ints.add(scanner.nextInt())
        }

        return findNumbers3(ints).toString()
    }

    fun findNumbers2(ints: List<Int>): Int {
        for (i in 0 until ints.size) {
            for (j in i + 1 until ints.size) {
                if (ints[i] + ints[j] == 2020) {
                    return ints[i] * ints[j]
                }
            }
        }

        return -1
    }

    fun findNumbers3(ints: List<Int>): Int {
        for (i in 0 until ints.size) {
            for (j in i + 1 until ints.size) {
                for (k in j + 1 until ints.size) {
                    if (ints[i] + ints[j] + ints[k] == 2020) {
                        return ints[i] * ints[j] * ints[k]
                    }
                }
            }
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec1().solve(scanner))
}