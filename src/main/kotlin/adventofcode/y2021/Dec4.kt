package adventofcode.y2021;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec4 {
    fun solve(scanner: Scanner): String {
        val numbers = scanner.nextLine().split(",").map { it.toInt() }.toMutableList()
        var boards = readBoards(scanner)

        while (numbers.isNotEmpty()) {
            val num = numbers.removeFirst()

            boards = boards.map { it - num }

            val b = boards.filter { it.isBingo() }
            if (b.isNotEmpty()) {
                return "${num * b[0].sum()}"
            }
        }

        return "0"
    }

    private fun readBoards(scanner: Scanner): List<Board> {
        val boards = mutableListOf<Board>()
        while (scanner.hasNextLine()) {
            scanner.nextLine()
            val lines = (0..4).map { scanner.nextLine() }.map { it.split(" ").filter { it.isNotEmpty() }.map { it.toInt() } }

            val b = Board(lines.map { it.toSet() }, (0..4).map { i -> lines.map { it[i] }.toSet() })
            boards.add(b)
        }

        return boards
    }

    fun solve2(scanner: Scanner): String {

        val numbers = scanner.nextLine().split(",").map { it.toInt() }.toMutableList()
        var boards = readBoards(scanner)

        while (numbers.isNotEmpty()) {
            val num = numbers.removeFirst()

            boards = boards.map { it - num }

            val b = boards.filterNot { it.isBingo() }
            if (b.isEmpty()) {
                return "${num * boards[0].sum()}"
            } else {
                boards = b
            }
        }

        return "0"
    }

    data class Board(val rows: List<Set<Int>>, val cols: List<Set<Int>>) {
        operator fun minus(v: Int): Board = Board(rows.map { it - v }, cols.map { it - v })
        fun isBingo(): Boolean {
            val r = rows.filter { it.isEmpty() }
            val c = cols.filter { it.isEmpty() }

            return r.isNotEmpty() || c.isNotEmpty()
        }

        fun sum(): Int = rows.sumOf { it.sum() }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec4().solve(scanner))
}