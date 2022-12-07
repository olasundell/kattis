package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FindingAnA {
    fun solve(scanner: Scanner): String {
        val subst = scanner.nextLine().substringAfter('a')

        return "a${subst}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FindingAnA().solve(scanner))
}