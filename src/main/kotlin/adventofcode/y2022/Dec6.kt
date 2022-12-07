package adventofcode.y2022;

import java.util.*

/**
 * TODO write documentation
 */
class Dec6(private val size: Int = 4) {
	fun solve(scanner: Scanner): String {
		val line = scanner.nextLine()
		((size - 1) until line.length).forEach {
			if (line.substring((it - size + 1)..it).toSet().size == size) {
				return "${it + 1}"
			}
		}
		return ""
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec6().solve(scanner))
}