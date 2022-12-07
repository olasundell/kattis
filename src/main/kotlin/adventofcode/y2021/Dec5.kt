package adventofcode.y2021;

import java.awt.Point
import java.util.Scanner;
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

/**
 * TODO write documentation
 */
class Dec5(private val diagonals: Boolean = false) {
    fun solve(scanner: Scanner): String {
        val map = mutableMapOf<Point, Int>()

        while (scanner.hasNextLine()) {
            val p = readPoints(scanner.nextLine())

            p.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
        }

//        (0..10).forEach { y ->
//            (0..10).forEach { x ->
//                val f = map.getOrDefault(Point(x, y), 0)
//                if (f == 0) {
//                    print(".")
//                } else {
//                    print(f)
//                }
//            }
//            println()
//        }

        return "${map.filterValues { it > 1 }.size}"
    }

    fun readPoints(s: String): List<Point> {
        val p = s.split(" -> ").map { it.split(",") }.map { Point(it[0].toInt(), it[1].toInt()) }

        val x1 = min(p[0].x, p[1].x)
        val x2 = max(p[0].x, p[1].x)

        val y1 = min(p[0].y, p[1].y)
        val y2 = max(p[0].y, p[1].y)

        return if (p[0].x == p[1].x) {
            (y1..y2).map { Point(p[0].x, it) }
        } else if (p[0].y == p[1].y) {
            (x1..x2).map { Point(it, p[0].y) }
        } else if (diagonals) {
            val m = (p[0].y - p[1].y) / (p[0].x - p[1].x)

            if (m > 0) {
                (0..(x2 - x1)).map { Point(x1 + it, y1 + it) }
            } else {
                (0..(x2 - x1)).map { Point(x1 + it, y2 - it) }
            }
        } else {
            listOf()
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec5().solve(scanner))
}