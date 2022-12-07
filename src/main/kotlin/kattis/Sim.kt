package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Sim {
	fun solve(scanner: Scanner): String {
		val n = scanner.nextInt()
		scanner.nextLine()
		val results = mutableListOf<String>()

		repeat(n) {
			val line = scanner.nextLine()

			val result = mutableListOf<Char>()
			var pos = 0

			for (c in line) {
				when (c) {
					'[' -> pos = 0
					']' -> pos = result.size
					'<' -> if (pos != 0) result.removeAt(--pos)
					else -> result.add(pos++, c)
				}
			}

			results.add(result.joinToString(separator = ""))
		}

		return results.joinToString("\n")
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Sim().solve(scanner))
}