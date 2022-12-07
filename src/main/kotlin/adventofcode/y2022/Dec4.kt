package adventofcode.y2022;

import java.util.*

/**
 * TODO write documentation
 */
class Dec4(private val totallyContained: Boolean = true) {
	fun solve(scanner: Scanner): String {
		val pairs = mutableListOf<Pair<IntRange, IntRange>>()
		while (scanner.hasNextLine()) {
			val l = scanner.nextLine().split(",")

			val p1 = l[0].split("-")
			val p2 = l[1].split("-")

			val intRange1 = p1[0].toInt()..p1[1].toInt()
			val intRange2 = p2[0].toInt()..p2[1].toInt()

			pairs.add(intRange1 to intRange2)

		}

		val count = pairs.count {
			val left = it.first.toSet()
			val right = it.second.toSet()

			if (totallyContained) {
				left.containsAll(right) || right.containsAll(left)
			} else {
				left.union(right).size < left.size + right.size
			}
		}

		return "$count"
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec4().solve(scanner))
}