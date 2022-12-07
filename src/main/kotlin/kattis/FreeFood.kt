package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FreeFood {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val s = (0 until n).map { (scanner.nextInt()..scanner.nextInt()).toSet() }
            .reduce { acc, ints -> acc + ints }

        return "${s.size}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FreeFood().solve(scanner))
}