package adventofcode.y2021;

import java.util.Scanner;


/**
 * TODO write documentation
 */
class Dec12 {
	fun solve(scanner: Scanner): String {
		val map = mutableMapOf<String, List<String>>()
		val revMap = mutableMapOf<String, List<String>>()
		while (scanner.hasNextLine()) {
			val line = scanner.nextLine()
			val from = line.split("-")[0]
			val to = line.split("-")[1]

			map[from] = map[from]?.plus(to) ?: listOf(to)
			revMap[to] = revMap[to]?.plus(from) ?: listOf(from)
		}

		val list = iterate("start", map, listOf())

		return ""
	}

	private fun iterate(s: String, map: Map<String, List<String>>, visited: List<String>): List<String> {
		if (s.isEnd()) {
			return visited + "end"
		}
		if (s.isMulti()) {
//			return map[s].orEmpty().map {
//				iterate(it, map, visited + s)
//			}
		}

		return listOf()
	}

	private fun String.isMulti(): Boolean = !(this.isEnd() || this.isStart()) && this.uppercase() == this
	private fun String.isEnd(): Boolean = this == "end"
	private fun String.isStart(): Boolean = this == "start"

}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec12().solve(scanner))
}