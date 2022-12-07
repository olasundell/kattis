package adventofcode.y2020;

import java.text.NumberFormat
import java.util.*

/**
 * TODO write documentation
 */
class Dec13 {
    fun solve(scanner: Scanner): String {
        val start = scanner.nextLine().toInt()
        val list = scanner.nextLine().split(",").filterNot { it == "x" }.map { it.toInt() }

        Long.MAX_VALUE

        var min = Int.MAX_VALUE
        var id = 0

        for (i in list.indices) {
            val f = list[i] - (start % list[i])
            if (f < min) {
                min = f
                id = list[i]
            }
        }

        return "${min * id}"
    }

    fun solve2(scanner: Scanner): String {
        val start = scanner.nextLine().toInt()
        val map: Map<Int, Long> = scanner.nextLine()
            .split(",")
            .mapIndexed { index, s ->
                if (s != "x") {
                    index to s.toLong()
                } else {
                    index to -1L
                }
            }
            .filterNot { it.second == -1L }
            .toMap()

        val keys = map.keys.toList().sorted()

        return execute2(map, keys)
    }

    private fun execute2(map: Map<Int, Long>, keys: List<Int>): String {
        var mult: Long = map[0]!!
        var start: Long = map[0]!!

        for (i in 1 until keys.size) {
            val key = keys[i]
            val value = map[key]!!
            start = delegate(start, mult, key, value)
            mult = lcm(mult, value)
        }

        return start.toString()
    }

    fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
    fun lcm(a: Long, b: Long): Long = a / gcd(a, b) * b

    private fun delegate(start:Long, mult: Long, keyIdx2: Int, id2: Long): Long {
        var i = start
        while (true) {
            val l: Long = (i + keyIdx2) % id2

            if (l == 0L) {
                return i
            }

            i += mult
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec13().solve(scanner))
}