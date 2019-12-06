package adventofcode.y2019;

import java.util.*
import kotlin.math.abs

/**
 * TODO write documentation
 */
class Dec3 {
    fun solve(scanner: Scanner): String {
        val firstWire = scanner.nextLine().split(",").map { Move(it[0], it.substring(1).toInt() ) }
        val secondWire = scanner.nextLine().split(",").map { Move(it[0], it.substring(1).toInt() ) }

        val firstPoints = points(firstWire)
        val secondPoints = points(secondWire)
        val intersection = intersections(firstPoints, secondPoints)
        return intersection.toString()
    }

    private fun intersections(firstPoints: Points, secondPoints: Points): Int {
        val intsct = firstPoints.points.intersect(secondPoints.points).minus(Pair(0, 0))

        return intsct.map { firstPoints.distances[it]!! + secondPoints.distances[it]!! }.fold(Int.MAX_VALUE) { acc, i -> acc.coerceAtMost(i) }

//        return intsct.fold(Int.MAX_VALUE) { acc, pair -> acc.coerceAtMost(abs(pair.first) + abs(pair.second)) }
    }

//    data class Intersection(val distance: Int)


    data class Points(val points: Set<Pair<Int, Int>>, val distances: Map<Pair<Int, Int>, Int>)

    fun points(firstWire: List<Move>): Points {
        val set = mutableSetOf<Pair<Int, Int>>()
        val distances = mutableMapOf<Pair<Int, Int>, Int>()
        var lastP = Pair(0, 0)
        set.add(lastP)
        var currD = 1

        for (m in firstWire) {
            repeat (m.distance) {
                val p = m.exec(lastP)
                distances.putIfAbsent(p, currD++)
                set.add(p)
                lastP = p
            }
        }

        return Points(set, distances)
    }

    data class Point(val x: Int, val y: Int, val distance: Int)

    data class Move(val dir: Char, val distance: Int) {
        fun exec(p: Pair<Int, Int>): Pair<Int, Int> {
            return when (dir) {
                'U' -> Pair(p.first, p.second - 1)
                'D' -> Pair(p.first, p.second + 1)
                'L' -> Pair(p.first - 1, p.second)
                'R' -> Pair(p.first + 1, p.second)
                else -> throw IllegalStateException("$dir is not a valid direction")
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec3().solve(scanner))
}