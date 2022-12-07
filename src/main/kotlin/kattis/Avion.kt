package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Avion {
    fun solve(scanner: Scanner): String {
        val list = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine())
        }
        val indices = mutableListOf<Int>()

        list.forEachIndexed { index, s ->
            if (s.contains("FBI")) {
                indices.add(index + 1)
            }
        }

        return if (indices.isEmpty()) {
            "HE GOT AWAY!"
        } else {
            indices.joinToString(separator = " ")
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Avion().solve(scanner))
}