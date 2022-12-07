package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class NSum {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        var s = 0

        while (scanner.hasNextInt()) {
            s += scanner.nextInt()
        }
        return "$s"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(NSum().solve(scanner))
}