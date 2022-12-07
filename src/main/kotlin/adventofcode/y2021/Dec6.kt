package adventofcode.y2021;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec6(private val iterations: Int) {
    fun solve(scanner: Scanner): String {
        val l = scanner.nextLine().split(",").map { it.toInt() }.toMutableList()

        repeat((0 until iterations).count()) {
            val s = l.size
            (0 until s).forEach { i ->
                if (l[i] == 0) {
                    l.add(8)
                    l[i] = 6
                } else {
                    l[i] -= 1
                }
            }
        }

        return "${l.size}"
    }

    fun solve2(scanner: Scanner): String {
        val l = scanner.nextLine().split(",").map { it.toInt() }.toMutableList()
        val map = mutableMapOf<Int, Long>()

        l.forEach { map.merge(it, 1L, Long::plus) }

        repeat(iterations) {
            val new = map.getOrDefault(0, 0)
            map[0] = map.getOrDefault(1, 0)
            map[1] = map.getOrDefault(2, 0)
            map[2] = map.getOrDefault(3, 0)
            map[3] = map.getOrDefault(4, 0)
            map[4] = map.getOrDefault(5, 0)
            map[5] = map.getOrDefault(6, 0)
            map[6] = map.getOrDefault(7, 0) + new
            map[7] = map.getOrDefault(8, 0)
            map[8] = new
        }

        return "${map.values.sum()}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec6(1).solve(scanner))
}