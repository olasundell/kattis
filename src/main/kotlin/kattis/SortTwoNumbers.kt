package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class SortTwoNumbers {
    fun solve(scanner: Scanner): String {
        return listOf(scanner.nextInt(), scanner.nextInt()).sorted().joinToString(" ")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SortTwoNumbers().solve(scanner))
}