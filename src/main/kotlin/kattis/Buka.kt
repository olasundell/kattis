package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Buka {
	fun solve(scanner: Scanner): String {
        val first = scanner.nextLine().toBigInteger()
        val operand = scanner.nextLine()
        val second = scanner.nextLine().toBigInteger()

        return if (operand == "+") {
            "${first + second}"
        } else {
            "${first * second}"
        }
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Buka().solve(scanner))
}