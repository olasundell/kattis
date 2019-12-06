package adventofcode.y2019;

import java.util.Scanner;
import kotlin.streams.toList

/**
 * TODO write documentation
 */
class Dec4 {
    fun solve(scanner: Scanner): String {
//        val start = scanner.next().map { it.toInt() }.toMutableList()
//        val end = scanner.next().map { it.toInt() }.toMutableList()

        var count = 0
        val threeCheck = scanner.next().equals("Y")
        val start = scanner.nextInt()
        val end = scanner.nextInt()

        for (i in start..end) {
            if (fit(threeCheck, i)) {
                count++
            }
        }

        return "$count"
    }

    fun fit(threeCheck: Boolean, int: Int): Boolean {
        val input = int.toString()

        if (!hasTwoInARow(input)) return false
        if (threeCheck) {
//            if (hasThreeInARowButNotTwoInRemainder(input)) return false
            if (hasThreeOrMoreInARowAndNoTwo(input)) return false
        }
        if (!isIncreasing(input)) return false

        return true
    }

    fun hasThreeInARowButNotTwoInRemainder(input: String): Boolean {
        val idx = findStrictThreeInARow(input)
        if (idx != -1) {
            val rest = when (idx) {
                0 -> input.substring(3)
                1 -> input.substring(4)
                2 -> input.substring(0, 2)
                3 -> input.substring(0, 3)
                else -> throw IllegalStateException("$idx is just plain weird")
            }

            if (!hasTwoInARow(rest)) {
                // nope, no two equal in a row
                return true
            } else if (rest.length == 3) {
                // all equal, which isn't good
                val set = rest.chars().toList().toSet()
                return set.size == 1
            }
        }

        return false
    }

    private fun isIncreasing(input: String): Boolean {
        var l = input[0].toInt()

        for (i in 1 until input.length) {
            if (input[i].toInt() < l) {
                return false
            }
            l = input[i].toInt()
        }
        return true
    }

    fun hasTwoInARow(input: String): Boolean {
        return """[\d]*(11|22|33|44|55|66|77|88|99|00)[\d]*""".toRegex().matches(input)
    }

    fun hasThreeOrMoreInARowAndNoTwo(input: String): Boolean {
        val r56 = """(.)\1{4,5}""".toRegex()
        val find = r56.find(input)
        if (find != null) {
            return true
        }

        val r4 = """(.)\1{3}""".toRegex()
        val result = r4.find(input)

        if (result != null) {
            if (result.range.contains(0)) {
                return !hasTwoInARow(input.substring(result.range.last + 1))
            }
            if (result.range.contains(5)) {
                return !hasTwoInARow(input.substring(0, result.range.first))
            }

            return true
        }

        return hasThreeInARowButNotTwoInRemainder(input)
    }

    fun findStrictThreeInARow(input: String): Int {
        for (i in 0..3) {
            val threeInARow = input[i] == input[i + 1] && input[i + 1] == input[i + 2]
            val firstDifferent = (i != 0 && input[i - 1] != input[i]) || i == 0
            val lastDifferent = (i != 3 && input[i + 3] != input[i + 2]) || i == 3
            if (threeInARow && firstDifferent && lastDifferent) {
                return i
            }
        }
        return -1
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec4().solve(scanner))
}