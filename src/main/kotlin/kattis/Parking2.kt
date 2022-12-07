package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Parking2 {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()

        val results = mutableListOf<Int>()

        for (i in 0 until n) {
            scanner.nextLine()
            val p = scanner.nextLine().split(" ").map { it.toInt() }

            results.add((p.maxOrNull()!! - p.minOrNull()!!) * 2)

        }

        return results.joinToString("\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Parking2().solve(scanner))
}