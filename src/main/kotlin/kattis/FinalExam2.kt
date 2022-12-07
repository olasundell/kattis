package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FinalExam2 {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val grades = (0 until n).map { scanner.next() }

        var score = 0

        (1 until n).forEach { if (grades[it] == grades[it - 1]) score++ }

        return "$score"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FinalExam2().solve(scanner))
}