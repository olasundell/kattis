package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Kafkaesque {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        var cnt = 1
        var prev = 0

        while (scanner.hasNextInt()) {
            val c = scanner.nextInt()
            if (c < prev) {
                cnt++
            }

            prev = c
        }

        return "$cnt"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Kafkaesque().solve(scanner))
}