package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class AlienNumbers {
	fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val results = (1..n).map {
            val number = scanner.next()
            val source = scanner.next()
            val target = scanner.next()

            val result = calc(number, source, target)

            "Case #$it: $result"
        }
		return results.joinToString("\n")
	}

	private fun calc(number: String, source: String, target: String): String {
		val sourceMap = source.mapIndexed { index, c -> c to index }.toMap()
		val sourceRadix = sourceMap.size

		val targetMap = target.mapIndexed { index, c -> index to c }.toMap()
		val targetRadix = targetMap.size

		val trN = number.map { sourceMap[it] ?: 0 }
		val trNumber = trN.foldRightIndexed(0L) { index, i, acc -> acc + (index * sourceRadix).coerceAtLeast(1) * i }

//		val result = trNumber.toString().foldRightIndexed("") {
//			index, i, acc ->
//				val l = (index * targetRadix).coerceAtLeast(1) * i.digitToInt()
//				targetMap[l]!! + acc
//		}

		return deradix(trNumber, targetRadix, targetMap)
	}

	/*

		output = 0
		multiplier = 1
		foreach digit in digits:
			output = output + multiplier * digit
			multiplier = multiplier * base
	 */
	private fun deradix(num: Long, radix: Int, map: Map<Int, Char>): String {
		var l = num
		val list = mutableListOf<Int>()

		while (l > 0) {
			list.add((l % radix).toInt())
			l /= radix
		}

		val mapped = list.map {
			map[it]
		}.reversed()

		return mapped.joinToString("")
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(AlienNumbers().solve(scanner))
}