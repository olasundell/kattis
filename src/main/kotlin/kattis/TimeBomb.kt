package kattis;

import java.util.Scanner;

/**
 * ### ### ### ### ### ### ### ### ### ###
 * ***   * *** *** * * *** *** *** *** ***
 * * *   *   *   * * * *   *     * * * * *
 * * *   * *** *** *** *** ***   * *** ***
 * * *   * *     *   *   * * *   * * *   *
 * ***   * *** ***   * *** ***   * *** ***
 */

class TimeBomb {
    val map = mapOf(
    "ZERO" to """
***
* *
* *
* *
***""".timeBomb(),

    "ONE" to
"""
  *
  *
  *
  *
  *
""".timeBomb(),

    "TWO" to
"""
***
  *
***
*  
***
""".timeBomb(),
    "THREE" to
"""
***
  *
***
  *
***
""".timeBomb(),
    "FOUR" to
"""
* *
* *
***
  *
  *
""".timeBomb(),
    "FIVE" to
            """
***
*  
***
  *
***
""".timeBomb(),
    "SIX" to
"""
***
*  
***
* *
***
""".timeBomb(),
    "SEVEN" to
"""
***
  *
  *
  *
  *
""".timeBomb(),
    "EIGHT" to
"""
***
* *
***
* *
***
""".timeBomb(),
    "NINE" to
"""
***
* *
***
  *
***
""".timeBomb())

    fun solve(scanner: Scanner): String {
        val lines = mutableListOf(scanner.nextLine(),
        scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine())

        val number = mutableListOf<Int>()

        do {
            val next =
                    lines[0].substring(0, 3) +
                            lines[1].substring(0, 3) +
                            lines[2].substring(0, 3) +
                            lines[3].substring(0, 3) +
                            lines[4].substring(0, 3)

            val n = when (next.timeBomb()) {
                map["ZERO"] -> 0
                map["ONE"] -> 1
                map["TWO"] -> 2
                map["THREE"] -> 3
                map["FOUR"] -> 4
                map["FIVE"] -> 5
                map["SIX"] -> 6
                map["SEVEN"] -> 7
                map["EIGHT"] -> 8
                map["NINE"] -> 9
                else -> -1
            }

            if (n == -1) {
                return "BOOM!!"
            }

            number.add(n)

            if (lines[0].length == 3) {
                lines[0] = ""
            } else {
                for (i in 0 until 5) {
                    lines[i] = lines[i].substring(4)
                }
            }
        } while (lines[0].length >= 3)

        if (number.joinToString(separator = "").toInt() % 6 == 0) {
            return "BEER!!"
        }

        return "BOOM!!"
    }

    fun String.timeBomb(): Int {
        return this.replace("\n", "").map { if (it == '*') '1' else '0' }.joinToString(separator="").toInt(2)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(TimeBomb().solve(scanner))
}