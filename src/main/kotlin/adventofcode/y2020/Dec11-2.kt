package adventofcode.y2020;

import java.awt.Point
import java.lang.Integer.min
import java.util.Scanner;

/**
 * TODO write documentation
 */
class `Dec11-2`: Dec11() {
    fun solve2(scanner: Scanner): String {
        var list = read(scanner)
        val lookup = buildLookup(list)

        while (true) {
            val result = occupy2(list, lookup)
            if (!result.changed) {
//                println(result.list.map { it.joinToString(separator = "") }.joinToString(separator = "\n"))
//                return result.list.map { l -> l.count { it == '#' } }.sum().toString()
                return result.list.sumBy { row -> row.count { c -> c == '#' } }.toString()
            }
            list = result.list
//            if (i > 100) {
//                throw IllegalStateException("Ran for far too long")
//            }
//            if (i % 100 == 0) {
//                println(i)
//            }
//            i++
        }

        return ""
    }

    fun buildLookup(list: List<List<Char>>): Map<Point, List<Point>> {
        val map = mutableMapOf<Point, List<Point>>()
        list.forEachIndexed { y, row ->
            row.forEachIndexed { x, c ->
                if (c.isChair()) {
                    map[Point(x, y)] = trace(list, x, y)
                }
            }
        }

        return map
    }

    fun occupy2(list: List<List<Char>>, lookup: Map<Point, List<Point>>): Result {
        val result = list.toMutableList().map { it.toMutableList() }
        var changed = false
        for (y in list.indices) {
            for (x in list[y].indices) {
                val c = list[y][x]
                if (c != '.') {
                    val calcSeat = calcSeat2(list, lookup, x, y)
                    result[y][x] = calcSeat
                    if (c != calcSeat) {
                        changed = true
                    }
                }
            }
        }

        return Result(result, changed)
    }

    fun calcSeat2(list: List<List<Char>>, lookup: Map<Point, List<Point>>, xPos: Int, yPos: Int): Char {
        val occupied = lookup[Point(xPos, yPos)]!!.count { list[it.y][it.x].isInUse() }

        return if (list[yPos][xPos].isInUse() && occupied < 5) {
            '#'
        } else if (list[yPos][xPos].isFree() && occupied == 0) {
            '#'
        } else {
            'L'
        }
    }

    fun trace(list: List<List<Char>>, x: Int, y: Int): List<Point> {
        val result = mutableListOf<Point>()

        // up left
        for (i in 1..min(x, y)) {
            if (list[y - i][x - i].isChair()) {
                result.add(Point(x - i, y - i))
                break
            }
        }

        // left
        for (i in 1..x) {
            if (list[y][x - i].isChair()) {
                result.add(Point(x - i, y))
                break
            }
        }

        // down left
        for (i in 1..min(x, list.size - y - 1)) {
            if (list[y + i][x - i].isChair()) {
                result.add(Point(x - i, y + i))
                break
            }
        }

        // down
        for (i in 1 until (list.size - y)) {
            if (list[y + i][x].isChair()) {
                result.add(Point(x, y + i))
                break
            }
        }

        // down right
        for (i in 1 until min(list[y].size - x, list.size - y)) {
            if (list[y + i][x + i].isChair()) {
                result.add(Point(x + i, y + i))
                break
            }
        }

        // right
        for (i in 1 until (list[y].size - x)) {
            if (list[y][x + i].isChair()) {
                result.add(Point(x + i, y))
                break
            }
        }

        // up right
        for (i in 1..min(list[y].size - x - 1, y)) {
            if (list[y - i][x + i].isChair()) {
                result.add(Point(x + i, y - i))
                break
            }
        }

        // up
        for (i in 1..y) {
            if (list[y - i][x].isChair()) {
                result.add(Point(x, y - i))
                break
            }
        }

        return result
    }

    fun Char.isFree(): Boolean = this == 'L'
    fun Char.isInUse(): Boolean = this == '#'
    fun Char.isChair(): Boolean = this.isFree() || this.isInUse()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(`Dec11-2`().solve(scanner))
}