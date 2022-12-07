package adventofcode.y2021;

import java.util.Scanner;

/**
 *  0:      1:      2:      3:      4:
 *  aaaa    ....    aaaa    aaaa    ....
 * b    c  .    c  .    c  .    c  b    c
 * b    c  .    c  .    c  .    c  b    c
 *  ....    ....    dddd    dddd    dddd
 * e    f  .    f  e    .  .    f  .    f
 * e    f  .    f  e    .  .    f  .    f
 *  gggg    ....    gggg    gggg    ....
 *
 * 5:      6:      7:      8:      9:
 *  aaaa    aaaa    aaaa    aaaa    aaaa
 * b    .  b    .  .    c  b    c  b    c
 * b    .  b    .  .    c  b    c  b    c
 *  dddd    dddd    ....    dddd    dddd
 * .    f  e    f  .    f  e    f  .    f
 * .    f  e    f  .    f  e    f  .    f
 *  gggg    gggg    ....    gggg    gggg

 */
class Dec8 {
    fun solve(scanner: Scanner): String {
        var count = 0
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()

            val split = line.split(" | ")
            val filter = split[1].split(" ").filter { it.length in listOf(2, 3, 4, 7) }
            count += filter.size
        }
        return "${count}"
    }

    fun solve2(scanner: Scanner): String {
        var sum = 0
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()

            val split = line.split(" | ")
            val trTable = calc(split[0])
            val untranslated = split[1].split(" ").map { it.toSet() }
            val translated = untranslated.map { trTable[it] }.joinToString("").toInt()
            sum += translated
        }

        return "$sum"
    }

    private fun calc(s: String): Map<Set<Char>, Int> {
        val split = s.split(" | ")
        val m = mutableMapOf<String, Int>()

        val alts = ('a'..'g').toSet()

        val pos = mutableMapOf<Char, Set<Char>>()
        val def = mutableMapOf<Char, Char>()

        val pattern = split[0].split(" ")

        val one = pattern.filter { it.length == 2 }[0]
        val four = pattern.filter { it.length == 4 }[0]
        val seven = pattern.filter { it.length == 3 }[0]
        val eight = pattern.filter { it.length == 7 }[0]

        val a = seven.filter { !one.contains(it) }[0]
        val freq = calcFreq(pattern)

        def['a'] = a
        pos['a'] = setOf(a)
        pos['b'] = four.toCharArray().filter { !one.contains(it) }.filter { freq[it] == 6 }.toSet()
        pos['c'] = one.toCharArray().toSet().filter { freq[it] == 8 }.toSet()
        pos['d'] = four.toCharArray().filter { !one.contains(it) }.filter { freq[it] == 7 }.toSet()
        pos['f'] = one.toCharArray().toSet().filter { freq[it] == 9 }.toSet()

        pos['e'] = alts - pos['a']!! - pos['b']!! - pos['c']!! - pos['d']!! - pos['f']!!
        pos['g'] = alts - pos['a']!! - pos['b']!! - pos['c']!! - pos['d']!! - pos['f']!!

        pos['e'] = pos['e']!!.filter { freq[it] == 4 }.toSet()
        pos['g'] = pos['g']!!.filter { freq[it] == 7 }.toSet()

        return numbers(
            a = pos['a']!!.first(),
            b = pos['b']!!.first(),
            c = pos['c']!!.first(),
            d = pos['d']!!.first(),
            e = pos['e']!!.first(),
            f = pos['f']!!.first(),
            g = pos['g']!!.first(),
        )
    }


    private fun numbers(
        a: Char,
        b: Char,
        c: Char,
        d: Char,
        e: Char,
        f: Char,
        g: Char
    ): Map<Set<Char>, Int> = mapOf(
        setOf(a, b, c, e, f, g) to 0,
        setOf(c, f) to 1,
        setOf(a, c, d, e, g) to 2,
        setOf(a, c, d, f, g) to 3,
        setOf(b, c, d, f) to 4,
        setOf(a, b, d, f, g) to 5,
        setOf(a, b, d, e, f, g) to 6,
        setOf(a, c, f) to 7,
        setOf(a, b, c, d, e, f, g) to 8,
        setOf(a, b, c, d, f, g) to 9,
    )

    private fun calcFreq(pattern: List<String>): Map<Char, Int> {
        val freq = mutableMapOf<Char, Int>()
        pattern.map { s -> s.map { freq.merge(it, 1, Int::plus) } }

        return freq
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec8().solve(scanner))
}