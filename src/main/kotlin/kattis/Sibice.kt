package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Sibice {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val width = scanner.nextInt()
        val length = scanner.nextInt()
        val diagonal = Math.floor(Math.sqrt((width * width + length * length).toDouble()))
        val results = mutableListOf<Boolean>()

        for (i in 1..n) {
            results.add(scanner.nextInt() <= diagonal)
        }

        return results.map { b -> if (b) { "DA" } else { "NE" }}
                .joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Sibice().solve(scanner))
}