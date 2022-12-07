package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class SpellingBee {
    fun solve(scanner: Scanner): String {
        val initial = scanner.nextLine()
        val must = initial[0]
        val available = initial.toSet()

        val n = scanner.nextLine().toInt()

        val valid = mutableListOf<String>()

        while (scanner.hasNextLine()) {
            val l = scanner.nextLine()
            if (l.length >= 4) {
                val unique = l.toSet()

                if (unique.contains(must) && unique.all { available.contains(it) }) {
                    valid.add(l)
                }
            }
        }

        return valid.joinToString("\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SpellingBee().solve(scanner))
}