package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class MagicTrick {
    fun solve(scanner: Scanner): String {
        val s = scanner.next()
        if (s.length.toLong() == s.chars().distinct().count()) {
            return "1"
        }
        return "0"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(MagicTrick().solve(scanner))
}