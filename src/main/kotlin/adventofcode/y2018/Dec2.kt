package adventofcode.y2018;

import java.util.*

class Dec2 {
    fun solve(scanner: Scanner): String {
        val map = mutableMapOf<Int, Int>()
        var two = 0
        var three = 0

        while (scanner.hasNextLine()) {
            when (val n = scanLine(scanner.nextLine())) {
                2 -> two++
                3 -> three++
                6 -> {
                    two++
                    three++
                }
            }
        }

        return (two * three).toString()
    }

    private fun scanLine(nextLine: String): Int {
        val charsMap = mutableMapOf<Char, Int>()

        nextLine.forEach {
            charsMap[it] = charsMap.getOrDefault(it, 0) + 1
        }

        var n = 1

        val three = charsMap.filter { entry -> entry.value == 3 }.isNotEmpty()
        val two = charsMap.filter { entry -> entry.value == 2 }.isNotEmpty()

        if (three) {
            n *= 3
        }

        if (two) {
            n *= 2
        }

        return if (n == 1) {
            0
        } else {
            n
        }
    }

    fun solve2(scanner: Scanner): String {
        val lines = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine())
        }

        for (i in 0 until lines.size) {
            for (j in i + 1 until lines.size) {
                val s = compareLines(lines[i], lines[j])
                if (s != FAIL) {
                    return s
                }
            }
        }

        return ""
    }

    private val FAIL = ""

    private fun compareLines(first: String, second: String): String {
        var discrep = 0
        var idx = -1
        for (k in 0 until first.length) {
            if (first[k] != second[k]) {
                discrep++

                if (discrep > 1) {
                    return FAIL
                } else {
                    idx = k
                }
            }
        }

        return "${first.subSequence(0, idx)}${first.subSequence(idx+1, first.length)}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec2().solve(scanner))
}