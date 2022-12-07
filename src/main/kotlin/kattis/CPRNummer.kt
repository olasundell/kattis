package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class CPRNummer {
    fun solve(scanner: Scanner): String {
        val mult = listOf(4, 3, 2, 7, 6, 5, 4, 3, 2, 1)
        val sum = scanner.nextLine().filterNot { it == '-' }.map { (it - '0') }.mapIndexed { index, i -> i * mult[index] }.sum()

        return if (sum % 11 == 0) {
            "1"
        } else {
            "0"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(CPRNummer().solve(scanner))
}