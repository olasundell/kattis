package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class AddTwoNumbers {
    fun solve(scanner: Scanner): String {
        return "${scanner.nextInt() + scanner.nextInt()}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(AddTwoNumbers().solve(scanner))
}