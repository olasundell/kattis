package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Simone {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val k = scanner.nextInt()

        val c = (1..n).map { scanner.nextInt() }
        val m = mutableMapOf<Int, Int>()
        c.forEach { m[it] = m.getOrDefault(it, 0) + 1 }
//        val l = c.fold(mapOf<Int, Int>()) { acc, i -> acc.plus(i to (acc[i] ?? 0) + 1) }

        val cols = if (m.size < k) {
            // we have unused colours
            (1..k).toSet() - m.keys
        } else {
            val min = m.values.sorted()[0]
            m.filter { it.value == min }.map { it.key }.toSet()
        }

        return "${cols.size}\n${cols.sorted().joinToString(" ")}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Simone().solve(scanner))
}