package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class JudgingMoose {
    fun solve(scanner: Scanner): String {
        var first = scanner.nextInt();
        var second = scanner.nextInt();

        if (first == second) {
            if (first == 0) {
                return "Not a moose"
            } else {
                return "Even " + (first * 2).toString()
            }
        } else {
            return "Odd " + (Math.max(first, second) * 2).toString()
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(JudgingMoose().solve(scanner))
}