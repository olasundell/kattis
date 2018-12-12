package adventofcode.y2018;

import java.util.*

class Dec6 {
    val NONE = Point(-1, -1)
    fun solve(scanner: Scanner): String {
        val pointsAndBounds = readPoints(scanner)

        val unbounded = mutableSetOf<Point>()

        for (x in pointsAndBounds.min.x..pointsAndBounds.max.x) {
            unbounded.add(calc(pointsAndBounds, Point(x, pointsAndBounds.min.y)))
            unbounded.add(calc(pointsAndBounds, Point(x, pointsAndBounds.max.y)))
        }

        for (y in pointsAndBounds.min.y..pointsAndBounds.max.y) {
            unbounded.add(calc(pointsAndBounds, Point(pointsAndBounds.min.x, y)))
            unbounded.add(calc(pointsAndBounds, Point(pointsAndBounds.max.x, y)))
        }

        for (x in pointsAndBounds.min.x + 1 until pointsAndBounds.max.x) {
            for (y in pointsAndBounds.min.y + 1 until pointsAndBounds.max.y) {
                calc(pointsAndBounds, Point(x, y))
            }
        }

        return pointsAndBounds.points.filterNot { unbounded.contains(it) }
                .sortedByDescending { it.otherPoints.size }[0].otherPoints.size.toString()
    }

    private fun calc(pointsAndBounds: PointsAndBounds, p: Point): Point {
        val sortedBy = pointsAndBounds.points.map { Pair(it, manhattanDistance(it, p)) }.sortedBy { it.second }
        if (sortedBy[0].second == sortedBy[1].second ) {
            return NONE
        }

        val element = sortedBy[0].first

        element.otherPoints.add(p)

        return element
    }

    private fun manhattanDistance(one: Point, two: Point): Int {
        return Math.abs(one.x - two.x) + Math.abs(one.y - two.y)
    }

    fun solve2(scanner: Scanner): String {
        val pointsAndBounds = readPoints(scanner)
        var size = 0

        for (x in pointsAndBounds.min.x..pointsAndBounds.max.x) {
            for (y in pointsAndBounds.min.y..pointsAndBounds.max.y) {
                val p = Point(x, y)
                if (pointsAndBounds.points.map { manhattanDistance(it, p) }.reduce { acc, i -> acc + i } < 10_000) {
                    size++
                }
            }
        }
        return size.toString()
    }

    private fun readPoints(scanner: Scanner): PointsAndBounds {
        val set = mutableSetOf<Point>()
        var xMin = Int.MAX_VALUE
        var yMin = Int.MAX_VALUE
        var xMax = Int.MIN_VALUE
        var yMax = Int.MIN_VALUE

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().split(", ")
            val element = Point(line[0].toInt(), line[1].toInt())

            xMin = Math.min(element.x, xMin)
            yMin = Math.min(element.y, yMin)
            xMax = Math.max(element.x, xMax)
            yMax = Math.max(element.y, yMax)

            set.add(element)
        }

        return PointsAndBounds(set.toSet(), Point(xMin, yMin), Point(xMax, yMax))
    }

    data class PointsAndBounds(val points: Set<Point>, val min: Point, val max: Point)

    data class Point(val x: Int, val y: Int) {
        val otherPoints: MutableSet<Point> = mutableSetOf()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec6().solve(scanner))
}