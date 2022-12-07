package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class IRepeatMyself {
	fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()

        val list = (0 until n).map {
            val s = scanner.nextLine()
            minLength(s)
        }

		return list.joinToString("\n")
	}

    fun minLength(s: String): Int {
        var min = s.length

        for (i in (1..s.length)) {
            if (s.length % i == 0) {
                val chunks = s.chunked(s.length / i)
                val filter = chunks.filter { it == chunks[0] }
                if (filter.size == chunks.size) {
                    min = s.length / i
                }
            }
        }

        return min
    }
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(IRepeatMyself().solve(scanner))
}