package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Kleptography {
    fun solve(scanner: Scanner): String {
        val keyLen = scanner.nextInt()
        val phraseLen = scanner.nextInt()
        scanner.nextLine()

        val unencEnd = scanner.nextLine().map { it - 'a' }.toMutableList()
        val encrypted = scanner.nextLine().map { it - 'a' }.toMutableList()
        val result = mutableListOf<Int>()

        unencEnd.forEachIndexed { index, it -> result.add(decode(encrypted[encrypted.size - keyLen + index], it)) }

        for (j in (encrypted.size - 1 - keyLen) downTo 0) {
            val k = result[keyLen - 1]
            result.add(0, decode(encrypted[j], k))
        }

        result.addAll(unencEnd)

        for (i in 0 until keyLen) {
            result.removeAt(0)
        }

        return result.map { it + 'a'.toInt() }.map{ it.toChar() }.joinToString(separator = "")
    }

    private fun decode(c: Int, k: Int): Int = (26 + c - k) % 26
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Kleptography().solve(scanner))
}