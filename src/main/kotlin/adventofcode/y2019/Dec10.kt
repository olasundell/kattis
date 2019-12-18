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
//        val kMap = mutableMapOf<Pair<Point, Point>, Double>()
//        val kMap = mutableMapOf<Point, MutableSet<Pair<Point, Double>>>()

        for (p in points) {
            val others = points.toSet() - p
            val currentDirs = mutableSetOf<Direction>()
            val currentRevKMap = mutableMapOf<Direction, MutableSet<Point>>()
            for (p2 in others) {
                // (y - m) / x = k
                val direction = direction(p2, p)
                currentDirs.add(direction)
                currentRevKMap.getOrPut(direction) { mutableSetOf() }.add(p2)
//                kMap.putIfAbsent(p, mutableSetOf())
//                kMap[p]!!.add(p2 to k)
//                kMap[p2 to p] = k
//                revKMap.getOrPut(k) { mutableSetOf() }.add(p2 to p)
            }
            map[p] = currentDirs.size
            revKMap[p] = currentRevKMap
        }

        val sorted = map.entries.sortedByDescending { it.value }
        val first = sorted.first()
        point = first.key

        return "${first.key.x},${first.key.y},${first.value}"
    }

    fun direction(p2: Point, p: Point): Direction {
        val k = (p2.y - p.y).toDouble() / (p2.x - p.x).toDouble()
        return Direction(k, p.x > p2.x)
    }

    data class Direction(val k: Double, val left: Boolean) : Comparable<Direction> {
        override fun compareTo(other: Direction): Int {
            return if (other.left && !this.left) {
                1
            } else if (this.left && !other.left){
                -1
            } else {
                -other.k.compareTo(this.k)
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec10().solve(scanner))
}