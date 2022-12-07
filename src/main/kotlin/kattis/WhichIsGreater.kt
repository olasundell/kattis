package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class WhichIsGreater {
	fun solve(scanner: Scanner): String {
		return if (scanner.nextInt() > scanner.nextInt()) {
			"1"
		} else {
			"0"
		}
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(WhichIsGreater().solve(scanner))
}