package adventofcode.y2022;

import java.util.*

/**
 * TODO write documentation
 */
class Dec3 {
	fun solve(scanner: Scanner): String {
		var score = 0
		while (scanner.hasNextLine()) {
			val l = scanner.nextLine()

			val left = l.substring(0 until l.length / 2).toSet()
			val right = l.substring(l.length / 2).toSet()

			val inter = left.intersect(right)

			score += inter.sumOf {
				if (it.isLowerCase()) {
					it - 'a' + 1
				} else {
					it - 'A' + 27
				}
			}
		}
		return "$score"
	}

	fun solve2(scanner: Scanner): String {
		var score = 0
		val lines = mutableListOf<String>()

		while (scanner.hasNextLine()) {
			val l = scanner.nextLine()
			lines.add(l)
		}
		lines.chunked(3).map {
			val inter = it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet())

			score += inter.sumOf {
				if (it.isLowerCase()) {
					it - 'a' + 1
				} else {
					it - 'A' + 27
				}
			}
		}

		return "$score"
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec3().solve(scanner))
}