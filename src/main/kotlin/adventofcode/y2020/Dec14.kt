package adventofcode.y2020;

import java.util.*
import kotlin.math.max

/**
 * TODO write documentation
 */
class Dec14 {
//    val maskRegexp = "mask = X*?(?<mask>[01]\\w+)".toRegex()
    val maskRegexp = "mask = (?<mask>\\w+)".toRegex()
    val opRegexp = "mem\\[(?<bank>\\d+)\\] = (?<value>\\d+)".toRegex()

    fun solve(scanner: Scanner): String {
        val mem = mutableMapOf<Int, Long>()

        var mask = ""

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line.startsWith("mask")) {
                val match = maskRegexp.matchEntire(line)!!
                mask = match.groups["mask"]!!.value.reversed()
            } else {
                val match = opRegexp.matchEntire(line) ?: throw IllegalStateException("$line wasn't matched")
                val memBank = match.groups["bank"]!!.value.toInt()
                val number = match.groups["value"]!!.value.toLong()

                mem[memBank] = mask(mask, number)
            }
        }

        return "${mem.values.sum()}"
    }

    fun mask(mask: String, number: Long): Long {
        val bit = number.toString(2).reversed()
        val result = mutableListOf<Char>()

        for (i in mask.indices) {
            if (mask[i] != 'X') {
                result.add(mask[i])
            } else if (i < bit.length) {
                result.add(bit[i])
            } else {
                result.add('0')
            }
        }

        return result.reversed().joinToString(separator = "").toLong(2)
    }

    fun solve2(scanner: Scanner): String {
        val mem = mutableMapOf<Long, Long>()

        var mask = ""

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line.startsWith("mask")) {
                val match = maskRegexp.matchEntire(line)!!
                mask = match.groups["mask"]!!.value.reversed()
            } else {
                val match = opRegexp.matchEntire(line) ?: throw IllegalStateException("$line wasn't matched")
                val memBank = match.groups["bank"]!!.value.toInt()
                val number = match.groups["value"]!!.value.toLong()

                mask2(mask, memBank).forEach {
//                    mem[it] = mask(mask, number)
                    mem[it] = number
                }
            }
        }

        return "${mem.values.sum()}"
    }

    fun mask2(mask: String, number: Int): List<Long> {
        // prep
        val bit = number.toString(2).reversed()
        val m = mask.toCharArray()
//
//        val n = mutableListOf<Char>()
//
//        for (i in 0 until max(mask.length, bit.length)) {
//            if (i < mask.length &&
//                (mask[i] == 'X' || mask[i] == '1')
//            ) {
//                n.add(mask[i])
//            } else if (i < bit.length) {
//                n.add(bit[i])
//            }
//        }
//
//        val result = mutableListOf<Long>()
//        val mid = mutableListOf<String>()
//
//
//
        val list = iterate2(m.iterator(), bit.iterator())
        return list.map { it.reversed().toLong(2) }

//        if (mask.hasNext()) {
//            val m = mask.next()
//
//            if (m == 'X') {
//                return iterate2(mask, number).flatMap { listOf("0$it", "1$it") }
//            } else if (m == '1') {
//                return iterate2(mask, number).map { "1$it" }
//            } else if (n != null) {
//                return iterate2(mask, number).map { "$n$it" }
//            }
//        }

//        return list.map { it.reversed().toLong(2) }
    }

    fun iterate2(mask: Iterator<Char>, number: Iterator<Char>): List<String> {
        if (!mask.hasNext() && !number.hasNext()) {
            return listOf("")
        }

        val n: Char? = if (number.hasNext()) {
            number.next()
        } else {
            null
        }

        if (mask.hasNext()) {
            val m = mask.next()

            if (m == 'X') {
                return iterate2(mask, number).flatMap { listOf("0$it", "1$it") }
            } else if (m == '1') {
                return iterate2(mask, number).map { "1$it" }
            } else if (n != null) {
                return iterate2(mask, number).map { "$n$it" }
            } else {
                return iterate2(mask, number).map { "0$it" }
            }
        } else if (n != null) {
            return iterate2(mask, number).map { "$n$it" }
        }

        return listOf("")
    }

    fun iterate(mask: List<Char>, number: List<Char>): List<String> {
        if (mask.isEmpty() && number.isEmpty()) {
            return listOf()
        }

        val mSub = if (mask.isNotEmpty()) {
            mask.subList(1, mask.size)
        } else {
            listOf()
        }

        val nSub = if (number.isNotEmpty()) {
            number.subList(1, number.size)
        } else {
            listOf()
        }

        val iterate = iterate(mSub, nSub)

        if (mask.isNotEmpty()) {
            if (mask[0] == 'X') {
                return iterate
            } else if (mask[0] == '1') {
                return iterate.map { "1$it" }
            }
        }

        if (number.isNotEmpty()) {
            return iterate.map { "${number[0]}$it" }
        }

        return listOf()
    }

//    fun mask2(mask: String, number: Long): List<Long> {
//        val bit = number.toString(2).reversed()
//        val result = mutableListOf<Char>()
//
//        for (i in mask.indices) {
//            if (mask[i] != 'X') {
//                result.add(mask[i])
//            } else if (i < bit.length) {
//                result.add(bit[i])
//            } else {
//                result.add('0')
//            }
//        }
//
//        return result.reversed().joinToString(separator = "").toLong(2)
//    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec14().solve(scanner))
}