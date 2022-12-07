package codingame;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class RetroTypewriterArt {
	/*
	sp = space
bS = backSlash \
sQ = singleQuote '
and
nl = NewLine
	 */
	fun solve(scanner: Scanner): String {
		var str = ""
		while (scanner.hasNext()) {
			val n = scanner.next()
			str += parse(n)
		}
		return str
	}

	private fun parse(n: String): String {
		if (n == "nl") {
			return "\n"
		}

		val lc = if (n.endsWith("sp")) {
			n.length - 2 to ' '
		} else if (n.endsWith("bS")) {
			n.length - 2 to '\\'
		} else if (n.endsWith("sQ")) {
			n.length - 2 to '\''
		} else {
			n.length - 1 to n.last()
		}

		return times(n.substring(0, lc.first), lc.second)
	}

	private fun times(s: String, c: Char): String {
		return (0 until s.toInt()).map { c }.joinToString("")
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(RetroTypewriterArt().solve(scanner))
}