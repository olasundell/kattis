package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class OddEcho {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val s = (0 until n).map { scanner.next() }.chunked(2).map { it[0] }

        return s.joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(OddEcho().solve(scanner))
}