package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Thanos {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val result = (1..n).map {
            calc(
                scanner.nextLong(),
                scanner.nextLong(),
                scanner.nextLong()
            )
        }
        return result.joinToString("\n")
    }

    private fun calc(pop: Long, growth: Long, food: Long): Int {
        var p = pop
        var i = 0
        while (p <= food) {
            i++
            p *= growth
        }

        return i
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Thanos().solve(scanner))
}