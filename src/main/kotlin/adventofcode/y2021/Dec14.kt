package adventofcode.y2021;

import java.lang.System.err
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec14(private val iterations: Int, private val calc: Boolean = false) {
	fun solve(scanner: Scanner): String {
        val pt = scanner.nextLine()
        scanner.nextLine()
        val pairs = mutableMapOf<String, Char>()
        while (scanner.hasNextLine()) {
            val p = scanner.nextLine().split(" -> ")
            pairs[p[0]] = p[1][0]
        }

		var str = pt
		val list = str.toMutableList()

		repeat(iterations) {
			(0 until str.length - 1).forEach {
				val c = "${str[it]}${str[it + 1]}"
				val element = pairs[c]!!
				list.add(it * 2 + 1, element)
			}
			str = list.joinToString("")
			err.println(it)
		}

		return if (calc) {
			val freqMap = str.groupingBy { it }.eachCount()
			val m = freqMap.entries.sortedByDescending { it.value }
			"${m.first().value - m.last().value}"
		} else {
			str
		}
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec14(0).solve(scanner))
}