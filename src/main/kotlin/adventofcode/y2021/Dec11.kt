package adventofcode.y2021;

import java.awt.Point
import java.util.Scanner;
import kotlin.math.max
import kotlin.math.min

/**
 * TODO write documentation
 */
class Dec11(val steps: Int) {
    fun solve(scanner: Scanner): String {

        var o = readOctopii(scanner)

        repeat(steps) {
            o = o.iterate()
        }

        return "${o.flashes}"
    }

    fun solve2(scanner: Scanner): String {

        var o = readOctopii(scanner)

        repeat(999_999_999) {
            o = o.iterate()
            if (o.isSync()) {
                return "${it}"
            }
        }

        return "-1"
    }

    fun readOctopii(scanner: Scanner): Octopii {
        val m = mutableListOf<List<Int>>()

        repeat(10) {
            val l = scanner.nextLine()
            m.add(l.toList().map { it.digitToInt() })
        }

        var o = Octopii(m)
        return o
    }

    data class Octopii(val m: List<List<Int>>, val flashes: Int = 0) {
        fun iterate(): Octopii {
            val f = flash(m)

            val t = f.first.map { l ->
                l.map {
                    it + 1
                }
            }

            return Octopii(t, flashes + f.second)
        }

        fun isSync(): Boolean = m.sumOf { l -> l.filter { it == 0 }.size } == 100

        private fun flash(t: List<List<Int>>): Pair<List<List<Int>>, Int> {
            var f = 0
            val map = t.toMutableList().map { it.toMutableList() }
            val nines = findNines(map)

            while (nines.isNotEmpty()) {
                nines.forEach {
                    map[it.y][it.x] = -1
                    f++
                }

                val surrounding = getSurrounding(nines, map).filterNot { map[it.key.y][it.key.x] == -1 }

                surrounding.forEach {
                    map[it.key.y][it.key.x] += it.value
                }

                nines.clear()
                nines.addAll(findNines(map))
            }

            return map to f
        }

        private fun findNines(map: List<List<Int>>): MutableSet<Point> {
            return map.flatMapIndexed { y, l ->
                l.mapIndexed { x, i ->
                    if (i >= 9) {
                        Point(x, y)
                    } else {
                        null
                    }
                }.filterNotNull()
            }.toMutableSet()
        }

        private fun getSurrounding(p: Set<Point>, l: List<List<Int>>): Map<Point, Int> {
            val map = mutableMapOf<Point, Int>()
            p.forEach {
                (max(0, it.x - 1)..min(9, it.x + 1)).forEach { x ->
                    (max(0, it.y - 1)..min(9, it.y + 1)).forEach { y ->
                        val element = Point(x, y)
                        if (!p.contains(element) || l[y][x] != -1) {
                            map.merge(element, 1, Int::plus)
                        }
                    }
                }
            }

            return map
        }

        override fun toString(): String {
            return m.joinToString("\n") { it.joinToString(separator = "") }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec11(1).solve(scanner))
}