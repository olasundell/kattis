package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class ElectricalOutlets {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val result = mutableListOf<Int>()

        repeat(n) {
            val m = scanner.nextInt()
            val sum = (0 until m).map { scanner.nextInt() }.sum()

            result.add(sum - m + 1)
        }

        return result.joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ElectricalOutlets().solve(scanner))
}