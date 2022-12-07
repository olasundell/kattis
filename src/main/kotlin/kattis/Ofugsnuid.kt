package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Ofugsnuid {
    fun solve(scanner: Scanner): String {
        scanner.next()
        val list = mutableListOf<Int>()
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt())
        }
        return list.reversed().joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Ofugsnuid().solve(scanner))
}