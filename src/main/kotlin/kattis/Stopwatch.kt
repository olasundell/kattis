package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Stopwatch {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val clicks = (0 until n).map { scanner.nextInt() }.chunked(2)

        if (clicks.last().size == 1) {
            return "still running"
        }

        val sum = clicks.map { it[1] - it[0] }.sum()

        return "$sum"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Stopwatch().solve(scanner))
}