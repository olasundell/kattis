package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class PokeChat {
	fun solve(scanner: Scanner): String {
		val alphabet = scanner.nextLine()
		val phrase = scanner.nextLine()

		return phrase.chunked(3).map {
			val toInt = it.toInt() - 1
			alphabet[toInt]
		}.joinToString("")
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(PokeChat().solve(scanner))
}