package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class DuTube {
	fun solve(scanner: Scanner): String {
		val n = scanner.nextInt()
		val allCats = mutableSetOf<Char>()
		(0 until n).map {
			val len = scanner.nextInt()
			val cats = scanner.next().asSequence()
			allCats.addAll(cats)
		}

		

		return ""
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(DuTube().solve(scanner))
}