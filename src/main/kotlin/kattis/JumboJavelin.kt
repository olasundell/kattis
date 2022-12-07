package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class JumboJavelin {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        return "${(1..n).map { scanner.nextInt() }.reduce { i, acc -> i + acc - 1 }}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(JumboJavelin().solve(scanner))
}