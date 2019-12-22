package adventofcode.y2019;

import java.awt.Point
import java.util.*

/**
 * TODO write documentation
 */
class Dec10 {
    val revKMap = mutableMapOf<Point, MutableMap<Direction, MutableSet<Point>>>()
    val points = mutableSetOf<Point>()
    var point: Point = Point(-1, -1)

    fun solve(scanner: Scanner): String {
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

        for (p in points) {
            val others = points.toSet() - p
            val currentDirs = mutableSetOf<Direction>()
            val currentRevKMap = mutableMapOf<Direction, MutableSet<Point>>()
            for (p2 in others) {
                val direction = Direction(p, p2)
                currentDirs.add(direction)
//                currentRevKMap.getOrPut(direction) { mutableSetOf() }.add(p2)
                currentRevKMap.putIfAbsent(direction, mutableSetOf())
                currentRevKMap[direction]!!.add(p2)
            }
            map[p] = currentDirs.size
            revKMap[p] = currentRevKMap
        }

        val sorted = map.entries.sortedByDescending { it.value }
        val first = sorted.first()
        point = first.key

        return "${first.key.x},${first.key.y},${first.value}"
    }

    data class Direction(val origin: Point, val p: Point) : Comparable<Direction> {
        val k = (p.y - origin.y).toDouble() / (p.x - origin.x).toDouble()
        val left = origin.x > p.x

        override fun hashCode(): Int {
            return Objects.hash(k, left)
        }

        override fun equals(other: Any?): Boolean {
            if (other == null || other !is Direction) {
                return false
            }

            return other.left == this.left && other.k == this.k
        }

        override fun compareTo(other: Direction): Int =
                when {
                    other.left && !this.left -> -1
                    this.left && !other.left -> 1
                    else -> -other.k.compareTo(this.k)
                }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec10().solve(scanner))
}