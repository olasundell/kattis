package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FYI {
    fun solve(scanner: Scanner): String {
        return if (scanner.nextLine().startsWith("555")) {
            "1"
        } else {
            "0"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FYI().solve(scanner))
}