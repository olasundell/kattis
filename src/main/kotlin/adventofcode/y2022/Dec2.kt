package adventofcode.y2022;

import java.util.*

/**
 * TODO write documentation
 */
class Dec2(private val xyzIsInstruction: Boolean = false) {
	fun solve(scanner: Scanner): String {
		var score = 0
		while (scanner.hasNextLine()) {
			val l = scanner.nextLine().split(" ")

			score += if (xyzIsInstruction) {
				instrRound(l[0][0], l[1][0])
			} else {
				round(l[0][0], l[1][0])
			}
		}

		return "$score"
	}

	fun instrRound(they: Char, instr: Char): Int =
		when (instr) {
			'X' -> when (they) {
				'A' -> 3
				'B' -> 1
				'C' -> 2
				else -> throw IllegalArgumentException("$they")
			}

			'Y' -> they.points() + 3
			'Z' -> 6 + when (they) {
				'A' -> 2
				'B' -> 3
				'C' -> 1
				else -> throw IllegalArgumentException("$they")
			}

			else -> throw IllegalArgumentException("$instr")
		}

	fun round(they: Char, me: Char): Int = me.points() + they.vs(me)

	enum class Move(points: Int) {
		Rock(1),
		Paper(2),
		Scissors(3);

		fun moveFromChar(c: Char): Move =
			when (c) {
				'A', 'X' -> Rock
				'B', 'Y' -> Paper
				'C', 'Z' -> Scissors
				else -> throw IllegalArgumentException("$c")
			}
	}


}

private fun Char.vs(me: Char): Int =
	when (me) {
		'X' -> when (this) {
			'A' -> 3
			'B' -> 0
			'C' -> 6
			else -> throw IllegalArgumentException()
		}

		'Y' -> when (this) {
			'A' -> 6
			'B' -> 3
			'C' -> 0
			else -> throw IllegalArgumentException()
		}

		'Z' -> when (this) {
			'A' -> 0
			'B' -> 6
			'C' -> 3
			else -> throw IllegalArgumentException()
		}

		else -> throw IllegalArgumentException()
	}

private fun Char.points(): Int =
	when (this) {
		'X', 'A' -> 1
		'Y', 'B' -> 2
		'Z', 'C' -> 3
		else -> throw IllegalArgumentException()
	}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec2().solve(scanner))
}