package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class JackOLanternJuxtaposition {
    fun solve(scanner: Scanner): String {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        val c = scanner.nextInt()

        return "${a * b * c}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(JackOLanternJuxtaposition().solve(scanner))
}