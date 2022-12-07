package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Tornbygge {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        val numbers = scanner.nextLine().split(" ")
        var n = 1
        var current = numbers[0]

        for (i in 1 until numbers.size) {
            if (current < numbers[i]) {
                n++
            }

            current = numbers[i]
        }

        return "${n}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Tornbygge().solve(scanner))
}