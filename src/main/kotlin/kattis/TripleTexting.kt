package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class TripleTexting {
	fun solve(scanner: Scanner): String {
        val line = scanner.nextLine()

        val parts = line.chunked(line.length / 3)

        val result = parts[0].mapIndexed { index, c -> maxOcc(parts, index) }.joinToString("")

		return result
	}

    private fun maxOcc(parts: List<String>, index: Int): Char {
		val l = listOf(parts[0][index], parts[1][index], parts[2][index])
		val m = l.fold(mapOf<Char, Int>()) { acc, c ->
			acc + mapOf(c to (acc[c]?.plus(1) ?: 1))
		}

	    val sm = m.map { it.value to it.key }.toMap().toSortedMap()

	    return sm[sm.lastKey()]!!
    }
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(TripleTexting().solve(scanner))
}