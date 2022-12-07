package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Keywords {
    fun solve(scanner: Scanner): String {
        val w = mutableSetOf<String>()

        scanner.nextLine()

        while (scanner.hasNextLine()) {
            w.add(scanner.nextLine().toLowerCase().replace("-", " "))
        }

        return w.size.toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Keywords().solve(scanner))
}