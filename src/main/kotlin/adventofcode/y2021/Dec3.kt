package adventofcode.y2021

import java.util.*

/**
 * TODO write documentation
 */
class Dec3 {
    fun solve(scanner: Scanner): String {
        val list = readList(scanner)

        val folded: List<Int> = foldList(list)

        val mostCommon = folded.map {
            if (it >= list.size / 2) {
                1
            } else {
                0
            }
        }

        val leastCommon = mostCommon.map {
            if (it == 0) {
                1
            } else {
                0
            }
        }.joinToString("")

        val lc = leastCommon.toInt(2)
        val mc = mostCommon.joinToString("").toInt(2)

        return "${lc * mc}"
    }

    private fun foldList(list: List<String>): List<Int> {
        val l = list[0].length

        val initial: List<Int> = (0 until l).map { 0 }

        val folded: List<Int> = list.fold(initial) { acc, s ->
            acc.mapIndexed { index, i ->
                i + if (s[index] == '1') {
                    1
                } else {
                    0
                }
            }
        }
        return folded
    }

    fun readList(scanner: Scanner): List<String> {
        val list = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine())
        }
        return list
    }

    fun solve2(scanner: Scanner): String {
        val list = readList(scanner)
//        val hilo = filter2(list)

        val high = filter(list.toList())
        val low = filter(list.toList(), false)

        return "${high.toInt(2) * low.toInt(2)}"
//        return "${hilo.first * hilo.second}"
    }

//    private fun filter2(list: List<String>): Pair<Int, Int> {
//        var hi = ""
//        var lo = ""
//
//        (0 until (list[0].length)).forEach { i ->
//            val c = list.filter { it[i] == '1' }.size
////            val c = list[i].count { it == '1' }
//            if (c >= list.size / 2) {
//                hi += "1"
//                lo += "0"
//            } else if (c == list.size / 2) {
//                hi += "0"
//                lo += "1"
//            }
//        }
//
//        return hi.toInt(2) to lo.toInt(2)
//    }

    fun filter3(list: List<String>): String {
        var idx = 0

        var l = list
        while (true) {
            val f = l.count { it[idx] == '1' }
            if (f >= (l.size / 2 + l.size % 2)) {
                l = l.filter { it[idx] == '1' }
            } else {
                l = l.filter { it[idx] == '0' }
            }
            if (l.size > 1) {
                idx++
            } else {
                return l[0]
            }
        }
    }

    fun filter(list: List<String>, high: Boolean = true): String {
        var idx = 0
        val hi = if (high) {
            '1'
        } else {
            '0'
        }
        val lo = if (high) {
            '0'
        } else {
            '1'
        }

        var l = list
        while (true) {
            val f = l.count { it[idx] == '1' }
            if (f >= (l.size / 2 + l.size % 2)) {
                l = l.filter { it[idx] == hi }
            } else {
                l = l.filter { it[idx] == lo }
            }
            if (l.size > 1) {
                idx++
            } else {
                return l[0]
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec3().solve(scanner))
}