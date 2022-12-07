package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class AsciiAddition {
    val zero = """
        xxxxx
        x...x
        x...x
        x...x
        x...x
        x...x
        xxxxx
    """.trimmy()

    val one = """
        ....x
        ....x
        ....x
        ....x
        ....x
        ....x
        ....x
        """.trimmy()

    val two = """
        xxxxx
        ....x
        ....x
        xxxxx
        x....
        x....
        xxxxx
        """.trimmy()

    val three = """
        xxxxx
        ....x
        ....x
        xxxxx
        ....x
        ....x
        xxxxx
        """.trimmy()

    val four = """
        x...x
        x...x
        x...x
        xxxxx
        ....x
        ....x
        ....x
        """.trimmy()

    val five = """
        xxxxx
        x....
        x....
        xxxxx
        ....x
        ....x
        xxxxx
        """.trimmy()

    val six = """
        xxxxx
        x....
        x....
        xxxxx
        x...x
        x...x
        xxxxx
        """.trimmy()

    val seven = """
        xxxxx
        ....x
        ....x
        ....x
        ....x
        ....x
        ....x
        """.trimmy()

    val eight = """
        xxxxx
        x...x
        x...x
        xxxxx
        x...x
        x...x
        xxxxx
        """.trimmy()

    val nine = """
        xxxxx
        x...x
        x...x
        xxxxx
        ....x
        ....x
        xxxxx
        """.trimmy()

    val plus = """
        .....
        ..x..
        ..x..
        xxxxx
        ..x..
        ..x..
        .....
        """.trimmy()

    fun solve(scanner: Scanner): String {
        val all = (1..7).map { scanner.nextLine() }.toList()
        val windowed: List<List<String>> = all.map { it.windowed(5, 6, true) }
        val foo = mutableListOf<Long>()

        for (i in 0 until windowed[0].size) {
            var w = ""
            for (j in 0 until windowed.size) {
                w += windowed[j][i]
            }
            foo.add(w.convert())
        }


        val expr = foo.map { toChar(it) }.joinToString(separator = "")

        val split = expr.split("+")

        val s = "${split[0].toInt() + split[1].toInt()}"

        val rows = mutableListOf<MutableList<String>>(
                mutableListOf(),
                mutableListOf(),
                mutableListOf(),
                mutableListOf(),
                mutableListOf(),
                mutableListOf(),
                mutableListOf()
        )

        for (i in 0  until 7 ) {
            rows[i].add(s.map { fromChar(it, i) }.joinToString(separator = "."))
        }

        return rows.map { it.joinToString(separator = ".") }.joinToString(separator = "\n")
    }

    fun fromChar(c: Char, row: Int): String {
        return when(c) {
            '0' -> zero.split("\n")[row]
            '1' -> one.split("\n")[row]
            '2' -> two.split("\n")[row]
            '3' -> three.split("\n")[row]
            '4' -> four.split("\n")[row]
            '5' -> five.split("\n")[row]
            '6' -> six.split("\n")[row]
            '7' -> seven.split("\n")[row]
            '8' -> eight.split("\n")[row]
            '9' -> nine.split("\n")[row]
            else -> throw IllegalArgumentException("$c is illegal")
        }
    }

    fun toChar(l: Long): Char {
        return when(l) {
            zero.convert() -> '0'
            one.convert() -> '1'
            two.convert() -> '2'
            three.convert() -> '3'
            four.convert()-> '4'
            five.convert() -> '5'
            six.convert() -> '6'
            seven.convert() -> '7'
            eight.convert() -> '8'
            nine.convert() -> '9'
            plus.convert() -> '+'
            else -> throw IllegalArgumentException("${l} isn't a valid input")
        }
    }

    fun String.trimmy(): String {
        return this.replace(" ", "").replaceFirst("\n", "")
    }

    fun String.convert(): Long {
        return this.replace("\n", "").map { if (it == 'x') '1' else '0' }.joinToString(separator="").toLong(2)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(AsciiAddition().solve(scanner))
}