package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Warehouse {
    fun solve(scanner: Scanner): String {
        val testCases = scanner.nextInt()

        return (1..testCases).map { testCase(scanner) }.joinToString(separator = "\n")
    }

    private fun testCase(scanner: Scanner): String {
        val n = scanner.nextInt()
        val map = mutableMapOf<String, Int>()

        for (i in 1..n) {
            val k = scanner.next()
            val v = scanner.nextInt()
            map.compute(k) { key: String, value: Int? -> value?.plus(v) ?: v }
        }

        val c = compareByDescending<MutableMap.MutableEntry<String, Int>> { it.value }
        val tb = c.thenBy { it.key }

        val joinToString = map.entries.sortedWith(tb).map { "${it.key} ${it.value}" }.joinToString(separator = "\n")
        return "${map.size}\n$joinToString"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Warehouse().solve(scanner))
}