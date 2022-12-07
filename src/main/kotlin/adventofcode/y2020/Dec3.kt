package adventofcode.y2020;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec3 {
    fun solve(scanner: Scanner): String {
        val lines = readLines(scanner)

        return "${findTrees(lines, 3)}"
    }

    fun solve2(scanner: Scanner): String {
        val lines = readLines(scanner)
        val result = findTrees(lines, 1) *
                findTrees(lines, 3) *
                findTrees(lines, 5) *
                findTrees(lines, 7) *
                findTrees(lines, 1, 2)

        return "$result"
    }

    private fun readLines(scanner: Scanner): MutableList<String> {
        val lines = mutableListOf<String>()

        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine())
        }
        return lines
    }

    private fun findTrees(lines: List<String>, stepX: Int, stepY: Int = 1): Long {
        var x = 0

        // skip first
        val width = lines[0].length
        var trees = 0L

        for (y in lines.indices step stepY) {
            if (lines[y][x] == '#') {
                trees++
            }
            x = (x + stepX) % width
        }

        return trees
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec3().solve(scanner))
}