package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class TheLastProblem {
    fun solve(scanner: Scanner): String {
        return "Thank you, ${scanner.nextLine()}, and farewell!"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(TheLastProblem().solve(scanner))
}