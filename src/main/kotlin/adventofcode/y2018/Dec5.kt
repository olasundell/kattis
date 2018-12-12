package adventofcode.y2018;

import java.util.*

class Dec5 {
    fun solve(scanner: Scanner): String {
        return reduceString(scanner.nextLine()).toString()
    }

    fun solve2(scanner: Scanner): String {
        var min = Int.MAX_VALUE
        val line = scanner.nextLine()
        for (c in 'a'..'z') {
            val removed  = removeChar(line, c)
            min = Math.min(min, reduceString(removed))
        }

        return min.toString()
    }

    private fun removeChar(line: String, c: Char): String = line.replace(c.toLowerCase().toString(), "")
            .replace(c.toUpperCase().toString(), "")

    private fun reduceString(line: String): Int {
        val DUMMY = '-'
        var prevChar = DUMMY
        val newLine = mutableListOf<Char>()

        for (c in line) {
            if (c.equals(prevChar, true) && !c.equals(prevChar)) {
                if (newLine.isNotEmpty()) {
                    prevChar = newLine.removeAt(newLine.size - 1)
                } else {
                    prevChar = DUMMY
                }
            } else {
                if (prevChar != DUMMY) {
                    newLine.add(prevChar)
                }

                prevChar = c
            }
        }

        newLine.add(prevChar)

        return newLine.size
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec5().solve(scanner))
}