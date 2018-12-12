package adventofcode.y2018;

import java.lang.System.out
import java.util.*

class Dec10 {
    fun solve(scanner: Scanner): String {
        val points : MutableSet<Point> = mutableSetOf<Point>()
        while (scanner.hasNextInt()) {
            points.add(Point(scanner.nextLong(), scanner.nextLong(), scanner.nextLong(), scanner.nextLong()))
        }

        var min = Long.MAX_VALUE
        var iterAtMin = 0

        for (i in 0..100_000) {
            val box = boundingBoxAtIter(points, i)
            if (box.sum() > min) {
                break
            }
            min = box.sum()
            iterAtMin = i
        }

        out.println("$min $iterAtMin")
        printPointsAtIter(points.toHashSet(), iterAtMin)

        return ""
    }

    private fun printPointsAtIter(points: HashSet<Point>, i: Int) {
        val set = points.map { Point(it.x + it.dx * i, it.y + it.dy * i, it.dx, it.dy) }.toHashSet()
        printPoints(set, boundingBox(set))
    }

    private fun boundingBoxAtIter(points: Set<Dec10.Point>, iter: Int): BoundingBox {
        var leftX = Long.MAX_VALUE
        var rightX = Long.MIN_VALUE
        var upY = Long.MAX_VALUE
        var downY = Long.MIN_VALUE

        points.forEach {
            leftX = Math.min(leftX, it.x + it.dx * iter)
            rightX = Math.max(rightX, it.x + it.dx * iter)
            upY = Math.min(upY, it.y + it.dy * iter)
            downY = Math.max(downY, it.y + it.dy * iter)
        }

        return BoundingBox(leftX, rightX, upY, downY)
    }

    private fun boundingBox(points: Set<Dec10.Point>): BoundingBox {
        var leftX = Long.MAX_VALUE
        var rightX = Long.MIN_VALUE
        var upY = Long.MAX_VALUE
        var downY = Long.MIN_VALUE

        points.forEach {
            leftX = Math.min(leftX, it.x)
            rightX = Math.max(rightX, it.x)
            upY = Math.min(upY, it.y)
            downY = Math.max(downY, it.y)
        }

        return BoundingBox(leftX, rightX, upY, downY)
    }

    private fun printPoints(points: Set<Point>, box: BoundingBox) {
        for (y in box.upY..box.downY) {
            for (x in box.leftX..box.rightX) {
                if (points.any { it.x == x && it.y == y }) {
                    out.print("#")
                } else {
                    out.print(".")
                }
            }
            out.println()
        }
    }

    data class BoundingBox(val leftX: Long, val rightX: Long, val upY: Long, val downY: Long) {
        fun sum(): Long {
            return (rightX - leftX) * (downY - upY)
        }

        override fun toString(): String {
            return "($leftX, $upY) ($rightX, $downY)"
        }
    }

    data class Point(val x: Long, val y: Long, val dx: Long, val dy: Long)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec10().solve(scanner))
}