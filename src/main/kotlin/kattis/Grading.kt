package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Grading {
    fun solve(scanner: Scanner): String {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        val c = scanner.nextInt()
        val d = scanner.nextInt()
        val e = scanner.nextInt()
        val score = scanner.nextInt()

        return when (score) {
            in a..100 -> "A"
            in b..(a-1) -> "B"
            in c..(b-1) -> "C"
            in d..(c-1) -> "D"
            in e..(d-1) -> "E"
            else -> "F"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Grading().solve(scanner))
}