package adventofcode.y2021;

import java.awt.Point
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec9 {
    fun solve(scanner: Scanner): String {
        val tubes = readTubes(scanner)

        return "${tubes.sumMins()}"
    }

    private fun readTubes(scanner: Scanner): LavaTubes {
        val l = mutableListOf<List<Int>>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            l.add(line.map { it - '0' })
        }

        val tubes = LavaTubes(l)
        return tubes
    }

    fun solve2(scanner: Scanner): String {
        val tubes = readTubes(scanner)

        val mins = tubes.localMins()

        val flooded = mins.map { tubes.flood(it) }.sortedByDescending { it.size }

        val subList = flooded.subList(0, 3)
        val s = subList.fold(1) { acc, points -> acc * points.size }

        return "$s"
    }

    data class LavaTubes(val m: List<List<Int>>) {
        fun sumMins(): Int = localMins().sumOf { m[it.x][it.y] + 1 }

        fun flood(p: Point): Set<Point> {
            val s = mutableSetOf(p)
            val r = mutableSetOf<Point>()

            while (s.isNotEmpty()) {
                r.addAll(s)
                val tmp = s.flatMap { getSurround(it).filterNot { r.contains(it) || s.contains(it) || m[it.x][it.y] == 9 } }
                s.clear()
                s.addAll(tmp)
            }

            return r
        }

        fun localMins(): List<Point> {
            val mins = mutableListOf<Point>()
            m.forEachIndexed { x, ints ->
                ints.forEachIndexed { y, _ ->
                    if (isLocalMin(Point(x, y))) {
                        mins.add(Point(x, y))
                    }
                }
            }

            return mins
        }

        private fun isLocalMin(p: Point): Boolean {
            val pv = m[p.x][p.y]
            val surround = getSurround(p)

            return surround.map { m[it.x][it.y] }.all { it > pv }
        }

        private fun getSurround(p: Point): Set<Point> {
            val s = mutableSetOf<Point>()
            if (p.x > 0) {
                s.add(Point(p.x - 1, p.y))
            }

            if (p.y > 0) {
                s.add(Point(p.x, p.y - 1))
            }

            if (p.x < m.size - 1) {
                s.add(Point(p.x + 1, p.y))
            }

            if (p.y < m[0].size - 1) {
                s.add(Point(p.x, p.y + 1))
            }

            return s
        }

    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec9().solve(scanner))
}