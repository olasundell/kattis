package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Chanukah {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val list = mutableListOf<Int>()

        while (scanner.hasNextInt()) {
            scanner.nextInt()
            list.add(scanner.nextInt())
        }

        val s = list.mapIndexed { index, i -> "${index + 1} ${tr(i)}" }.joinToString(separator = "\n")

        return s
    }

    private fun tr(n: Int): Int {
        var s = 0

        (0 until n).forEach { i ->
            s += i + 2
        }

        return s
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Chanukah().solve(scanner))
}