package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Pyramids {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        return "${floors(1, n)}"
    }

    private fun floors(level: Int, remaining: Int): Int {
        val side = 1 + (level - 1) * 2
        val demanded = side * side

        if (remaining >= demanded) {
            return floors(level + 1, remaining - demanded)
        } else {
            return level - 1
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Pyramids().solve(scanner))
}