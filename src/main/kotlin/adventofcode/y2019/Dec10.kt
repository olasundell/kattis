package adventofcode.y2019;

import java.awt.Point
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec10 {
    val revKMap = mutableMapOf<Point, MutableMap<Direction, MutableSet<Point>>>()
    var point: Point = Point(-1, -1)

    fun solve(scanner: Scanner): String {
        val points = mutableSetOf<Point>()
        var lineNo = 0
        var maxX = -1
        var maxY = -1

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()

            for (i in line.indices) {
                if (line[i] == '#') {
                    points.add(Point(i, lineNo))
                    maxX = Math.max(maxX, i)
                    maxY = Math.max(maxY, lineNo)
                }
            }

            lineNo++
        }

        val map = mutableMapOf<Point, Int>()

        for (origin in points) {
            val others = points.toSet() - origin
            val currentDirs = mutableSetOf<Direction>()
            val currentRevKMap = mutableMapOf<Direction, MutableSet<Point>>()
            for (p2 in others) {
                val direction = Direction(origin = origin, p = p2)
                currentDirs.add(direction)
                currentRevKMap.getOrPut(direction) { mutableSetOf() }.add(p2)
            }
            map[origin] = currentDirs.size
            revKMap[origin] = currentRevKMap
        }

        val sorted = map.entries.sortedByDescending { it.value }
        val first = sorted.first()
        point = first.key

        return "${first.key.x},${first.key.y},${first.value}"
    }

    fun direction(p: Point, origin: Point): Direction {
        return Direction(origin, p)
    }

    data class Direction(private val origin: Point, val p: Point) : Comparable<Direction> {
        val k = (p.y - origin.y).toDouble() / (p.x - origin.x).toDouble()
        fun isLeft(): Boolean = p.x < origin.x

        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Direction) {
                return false
            }
            if (other.k != this.k) {
                return false
            }
            if (this.isLeft() && other.isLeft()) {
                return true
            }
            if (!this.isLeft() && !other.isLeft()){
                return true
            }

            return false
        }

        override fun compareTo(other: Direction): Int =
                when {
                    // other is left of origin and this is right
                    other.isLeft() && !isLeft() -> -1
                    // other is right of origin and this is left
                    isLeft() && !other.isLeft() -> 1
                    else -> -other.k.compareTo(this.k)
                }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec10().solve(scanner))
}