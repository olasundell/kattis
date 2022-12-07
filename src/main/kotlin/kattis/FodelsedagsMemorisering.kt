package kattis;

import java.util.*

/**
 * TODO write documentation
 */
class FodelsedagsMemorisering {
    fun solve(scanner: Scanner): String {
        val map = mutableMapOf<String, Friend>()

        scanner.nextLine()

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().split(" ")
            val friend = Friend(line[0], line[1].toInt())
            map.compute(line[2]) { _, pf ->
                if (pf == null || pf.score < friend.score) {
                    friend
                } else {
                    pf
                }
            }
        }

        val s = map.values.map { it.name }.sorted().joinToString("\n")

        return "${map.size}\n${s}"
    }

    data class Friend(val name: String, val score: Int)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
}