package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class SimpleCronSpec {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        val cron = mutableListOf<CronEntry>()
        while (scanner.hasNextLine()) {
            cron.add(cronify(scanner.nextLine()))
        }

        var execs = 0
        var secs = 0

        for (h in (0 until 24)) {
            for (m in (0 until 60)) {
                for (s in (0 until 60)) {
                    val match = cron.count { it.matches(h, m, s) }
                    if (match > 0) {
                        secs++
                    }
                    execs += match
                }
            }
        }

        return "${secs} ${execs}"
    }

    fun parse(s: String, m: Int): Set<Int> {
        if (s == "*") {
            return (0 until m).toSet()
        }

        if (s.contains(",")) {
            return s.split(",").flatMap { parse(it, m) }.toSet()
        }

        if (s.contains("-")) {
            val pl = s.split("-")
            return (pl[0].toInt()..pl[1].toInt()).toSet()
        }

        return setOf(s.toInt())
    }

    private fun cronify(s: String): CronEntry {
        val split = s.split(" ")
        val h = parse(split[0], 24)
        val m = parse(split[1], 60)
        val s = parse(split[2], 60)
        return CronEntry(h, m, s)
    }

    data class CronEntry(val h: Set<Int>, val m: Set<Int>, val s: Set<Int>) {
        fun matches(h: Int, m: Int, s: Int): Boolean = this.h.contains(h) && this.m.contains(m) && this.s.contains(s)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SimpleCronSpec().solve(scanner))
}