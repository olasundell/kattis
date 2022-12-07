package adventofcode.y2020;

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.Scanner;
import kotlin.streams.toList

/**
 * TODO write documentation
 */
open class Dec11 {
    fun solve(scanner: Scanner): String {
        var list = read(scanner)
        var i = 0

        while (true) {
            val result = occupy(list)
            if (!result.changed) {
//                println(result.list.map { it.joinToString(separator = "") }.joinToString(separator = "\n"))
//                return result.list.map { l -> l.count { it == '#' } }.sum().toString()
                return result.list.sumBy { row -> row.count { c -> c == '#' } }.toString()
            }
            list = result.list
//            if (i > 100) {
//                throw IllegalStateException("Ran for far too long")
//            }
            if (i % 100 == 0) {
                println(i)
            }
            i++
        }
    }

    data class Result(val list: List<List<Char>>, val changed: Boolean)

    fun read(scanner: Scanner): List<List<Char>> {
        return scanner.tokens().map { it.toCharArray().toList() }.toList()
    }

    fun occupy(list: List<List<Char>>): Result {
        val result = list.toMutableList().map { it.toMutableList() }
        var changed = false
        for (y in list.indices) {
            for (x in list[y].indices) {
                val c = list[y][x]
                if (c != '.') {
                    val calcSeat = calcSeat(list, x, y)
                    result[y][x] = calcSeat
                    if (c != calcSeat) {
                        changed = true
                    }
                }
            }
        }

        return Result(result, changed)
    }

    fun calcSeat(list: List<List<Char>>, xPos: Int, yPos: Int): Char {
        var occupied = 0
        for (y in max(0, yPos - 1) until min(list.size, yPos + 2)) {
            for (x in max(0, xPos - 1) until min(list[y].size, xPos + 2)) {
                if (x == xPos && y == yPos) {
                    // do nothing
                } else if (list[y][x] == '#') {
                    occupied++
                }
            }
        }

        return if (list[yPos][xPos] == '#' && occupied < 4) {
            '#'
        } else if (list[yPos][xPos] == 'L' && occupied == 0) {
            '#'
        } else {
            'L'
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec11().solve(scanner))
}