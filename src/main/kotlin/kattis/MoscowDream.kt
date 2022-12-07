package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class MoscowDream {
    fun solve(scanner: Scanner): String {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        val c = scanner.nextInt()
        val n = scanner.nextInt()

        if (a == 0 || b == 0 || c == 0) {
            return "NO"
        }

        if ((a + b + c) < n || n < 3) {
            return "NO"
        }

        return "YES"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(MoscowDream().solve(scanner))
}