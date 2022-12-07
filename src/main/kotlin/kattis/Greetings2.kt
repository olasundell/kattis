package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Greetings2 {
    fun solve(scanner: Scanner): String {
        val size = scanner.nextLine().length - 2

        return "h${"e".repeat(size * 2)}y"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Greetings2().solve(scanner))
}