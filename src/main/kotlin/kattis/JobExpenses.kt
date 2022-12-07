package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class JobExpenses {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        val sum = scanner.nextLine().split(" ").filter { it.startsWith("-") }.map { it.toInt() * -1 }.sum()
        return "$sum"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(JobExpenses().solve(scanner))
}