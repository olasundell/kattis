package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class ShoppingListEasy {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()

        val sets = mutableListOf<Set<String>>()

        while (scanner.hasNextLine()) {
            sets.add(scanner.nextLine().split(" ").toSet())
        }

        val reduced = sets.reduce { acc, strings -> acc.intersect(strings) }.toList().sorted()

        return "${reduced.size}\n${reduced.joinToString("\n")}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ShoppingListEasy().solve(scanner))
}