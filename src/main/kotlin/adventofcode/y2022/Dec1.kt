package adventofcode.y2022;

import java.util.*

class Dec1(private val noOfElves: Int) {
	fun solve(scanner: Scanner): String {
		val elves = mutableListOf<Elf>()
		val c = mutableListOf<Int>()
		while (scanner.hasNextLine()) {
			val l = scanner.nextLine()

			if (l.isNotBlank()) {
				c.add(l.toInt())
			} else {
				elves.add(Elf(c.toList()))
				c.clear()
			}
		}

		elves.add(Elf(c.toList()))

		elves.sortByDescending { it.total() }
		val sum = elves.subList(0, noOfElves).sumOf { it.total() }
		return "$sum"
	}

	data class Elf(val snacks: List<Int>) {
		fun total(): Int = snacks.sum()
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	println(Dec1(1).solve(scanner))
}