package adventofcode.y2022;

import java.util.*

/**
 * TODO write documentation
 */
class Dec5(private val oneByOne: Boolean = true) {
	fun solve(scanner: Scanner): String {
		val n = scanner.nextLine().toInt()
		val lists = (0 until n).map {
			scanner.nextLine().toMutableList()
		}.toMutableList()

		val regexp = """move (\d+) from (\d+) to (\d+)""".toRegex()
		while (scanner.hasNextLine()) {
			val input = scanner.nextLine()
			val (num, from, to) = regexp.find(input)!!.destructured.toList().map { it.toInt() - 1 }

			if (oneByOne) {
				repeat(num + 1) {
					lists[to].add(0, lists[from].removeFirst())
				}
			} else {
				lists[to].addAll(0, lists[from].subList(0, num + 1))
				lists[from] = lists[from].subList(num + 1, lists[from].size)
			}
		}

		return lists.map { it[0] }.joinToString("")
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec5().solve(scanner))
}