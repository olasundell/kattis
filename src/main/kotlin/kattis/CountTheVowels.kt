package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class CountTheVowels {
	fun solve(scanner: Scanner): String {
		val q = scanner.nextLine().fold(0) { acc, c -> if (c.isVowel()) acc + 1 else acc }
		return "$q"
	}

	fun Char.isVowel(): Boolean = this.toLowerCase() in listOf('a', 'e', 'i', 'o', 'u')
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(CountTheVowels().solve(scanner))
}