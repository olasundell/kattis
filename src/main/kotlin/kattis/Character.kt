package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Character {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        var r = 0

        (1..n).forEach { i -> r += n - i }

        return "${r}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Character().solve(scanner))
}