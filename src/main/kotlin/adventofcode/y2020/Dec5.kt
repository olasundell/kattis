package adventofcode.y2020;

import java.util.*
import kotlin.math.max

/**
 * TODO write documentation
 */
class Dec5 {
    fun solve(scanner: Scanner): String {
        var max = 0
        while (scanner.hasNextLine()) {
            val id = scanner.nextLine().replace("[FL]".toRegex(), "0").replace("[BR]".toRegex(), "1").toInt(2)

            max = max(id, max)
        }

        return "$max"
    }

    fun solve2(scanner: Scanner): String {
        val pq = PriorityQueue<Int>()
        while (scanner.hasNextLine()) {
            val id = scanner.nextLine().replace("[FL]".toRegex(), "0").replace("[BR]".toRegex(), "1").toInt(2)
            pq.add(id)
        }

        for (i in (pq.minOrNull()!! + 1) until pq.maxOrNull()!!) {
            if (!pq.contains(i)) {
                return "$i"
            }
        }

        return "-1"
    }

//    fun solve2(scanner: Scanner): String {
//        val set = mutableSetOf<Int>()
//        while (scanner.hasNextLine()) {
//            val line = scanner.nextLine()
//            val row = line.substring((0..6)).replace('F', '0').replace('B', '1').toInt(2)
//            val seat = line.substring((7..9)).replace('L', '0').replace('R', '1').toInt(2)
//
//            set.add(row * 8 + seat)
//        }
//        val sorted = set.sorted()
//
//        return "$max"
//    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec5().solve(scanner))
}