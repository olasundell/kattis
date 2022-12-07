package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class DrunkVigenere {
    fun solve(scanner: Scanner): String {
        val s = scanner.nextLine().map { it - 'A' }
        val key = scanner.nextLine().map { it - 'A' }

        val i = 'Z' - 'A' + 1

        return s.mapIndexed { index, c ->
            if (index % 2 == 1) {
                (c + (key[index])) % i
            } else {
                (i + (c - (key[index]))) % i
            }
        }.map { 'A'.plus(it) }.joinToString(separator = "")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(DrunkVigenere().solve(scanner))
}