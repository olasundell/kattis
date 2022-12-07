package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class EyeOfSauron {
    fun solve(scanner: Scanner): String {
        val s = scanner.nextLine().split("()")

        return if (s[0].length != s[1].length || s[0].contains("(") || s[0].contains(")") || s[1].contains("(") || s[1].contains(")")) {
            "fix"
        } else {
            "correct"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(EyeOfSauron().solve(scanner))
}