package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class ProgressiveScramble {
	fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()

		val result = (0 until n).map {
			val line = scanner.nextLine()
			val action = line[0]
			val s = line.substring(2)

			if (action == 'e') {
				encrypt(s)
			} else {
				decrypt(s)
			}

		}

		return result.joinToString("\n")
	}

	fun encrypt(s: String): String {
		val arr = toInt(s)

		val mapped = mutableListOf<Int>()

		mapped.add(arr[0])

		(1 until arr.size).forEach { i -> mapped.add(arr[i] + mapped[i - 1]) }

		val mod = mapped.map { it % 27 }

		return toChar(mod).joinToString("")
	}

	fun decrypt(s: String): String {
		val arr = toInt(s)

		val mapped = mutableListOf<Int>()

		mapped.add(arr[0])

		(1 until arr.size).forEach { i -> mapped.add(arr[i] - mapped[i - 1] + i * 27) }

		val mod = mapped.mapIndexed { index, i ->  i % 27 }

		return toChar(mod).joinToString("")
	}

	private fun toInt(s: String) = s.map {
		if (it == ' ') {
			0
		} else {
			it.code - 'a'.code + 1
		}
	}

	private fun toChar(mod: List<Int>) = mod.map {
		if (it == 0) {
			' '
		} else {
			val i = (it - 1) + 'a'.code
			i.toChar()
		}
	}

}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(ProgressiveScramble().solve(scanner))
}