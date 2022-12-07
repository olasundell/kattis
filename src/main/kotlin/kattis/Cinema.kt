package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Cinema {
	fun solve(scanner: Scanner): String {
        var seats = scanner.nextInt()
        var rejected = 0
        val n = scanner.nextInt()

        repeat(n) {
            val g = scanner.nextInt()
            if (seats >= g) {
                seats -= g
            } else {
                rejected++
            }
        }

        return "$rejected"
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Cinema().solve(scanner))
}