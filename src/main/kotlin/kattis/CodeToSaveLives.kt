package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class CodeToSaveLives {
	fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
		scanner.nextLine()

        return (0 until n).joinToString("\n") {
	        val a = scanner.nextLine().replace(" ", "").toInt()
	        val b = scanner.nextLine().replace(" ", "").toInt()

	        val s = a + b

	        s.toString().toCharArray().joinToString(" ")
        }
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(CodeToSaveLives().solve(scanner))
}