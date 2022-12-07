package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class HailStone2 {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextLong()

        return "${rec(n)}"
    }

    private fun rec(n: Long): Int {
        return if (n == 1L) {
            1
        } else if (n % 2L == 1L) {
            rec(3 * n + 1) + 1
        } else {
            rec(n / 2) + 1
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(HailStone2().solve(scanner))
}