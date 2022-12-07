package kattis;

import java.awt.Point
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Display {
    val zero = '0' to """
+---+
|   |
|   |
+   +
|   |
|   |
+---+""".replace("\n", "")

    val one = '1' to """
    +
    |
    |
    +
    |
    |
    +""".replace("\n", "")

    val two = '2' to """
+---+
    |
    |
+---+
|    
|    
+---+""".replace("\n", "")

    val three = '3' to """
+---+
    |
    |
+---+
    |
    |
+---+""".replace("\n", "")

    val four = '4' to """
+   +
|   |
|   |
+---+
    |
    |
    +""".replace("\n", "")

    val five = '5' to """
+---+
|    
|    
+---+
    |
    |
+---+""".replace("\n", "")

    val six = '6' to """
+---+
|    
|    
+---+
|   |
|   |
+---+
""".replace("\n", "")

    val seven = '7' to """
+---+
    |
    |
    +
    |
    |
    +
""".replace("\n", "")

    val eight = '8' to """
+---+
|   |
|   |
+---+
|   |
|   |
+---+ 
""".replace("\n", "")

    val nine = '9' to """
+---+
|   |
|   |
+---+
    |
    |
+---+ 
""".trimIndent().replace("\n", "")

    val example = """
+---+  +---+     +---+  +---+
    |      |     |      |   |
    |      |  o  |      |   |
+---+  +---+     +---+  +---+
|          |  o      |      |
|          |         |      |
+---+  +---+     +---+  +---+"""

    val template =
            """
    +      +         +      +
    |      |         |      |
    |      |  o      |      |
    +      +         +      +
    |      |  o      |      |
    |      |         |      |
    +      +         +      +
""".replaceFirst("\n", "")

    val map = mapOf(
            zero, one, two, three, four, five, six, seven, eight, nine
    )

    val corners = listOf(0, 7, 17, 24)

    fun solve(scanner: Scanner): String {
        val lines = mutableListOf<String>()
        var input = scanner.nextLine()

        while (input != "end") {
            val chars = listOf(input[0], input[1], input[3], input[4])
            var currentLine: List<CharArray> = template.split("\n").map { it.toCharArray() }
            for (i in 0 until 4) {
                currentLine = paint(chars[i], i, currentLine)
            }

            var c = currentLine.map { it.joinToString(separator="") }

            lines.add(currentLine.map { it.joinToString(separator="") }.joinToString(separator = "\n"))

            input = scanner.nextLine()
        }

        lines.add("end")

        return lines.joinToString(separator = "\n\n")
    }

    fun paint(c: Char, idx: Int, s: List<CharArray>): List<CharArray> {
        val p = map[c] ?: error("Could not find ${c} in map")

        for (i in 0 until 5) {
            for (j in 0 until 7) {
                val c1: Char = p[j * 5 + i]
                s[j][i + corners[idx]] = c1
            }
        }

        return s
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Display().solve(scanner))
}