package kattis;

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.Scanner;

/**
 * TODO write documentation
 */
class SkruOp {
	fun solve(scanner: Scanner): String {
		val n = scanner.nextLine()

		var vol = 7

		while (scanner.hasNextLine()) {
			val nextLine = scanner.nextLine()
			vol = if (nextLine == "Skru op!") {
				min(10, vol + 1)
			} else {
				max(0, vol - 1)
			}
		}
		return "$vol"
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(SkruOp().solve(scanner))
}