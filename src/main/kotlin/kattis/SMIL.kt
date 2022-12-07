package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class SMIL {
    fun solve(scanner: Scanner): String {
        var s = scanner.nextLine()
        var offset = 0
        val result = mutableListOf<Int>()

        while (s.isNotEmpty()) {
            val f = s.findAnyOf(listOf(":)", ";)", ":-)", ";-)"))
            if (f == null) {
                s = ""
            } else {
                result.add(f.first + offset)
                offset += f.first + 1
                s = s.substring(f.first + 1)
            }
        }

        return result.joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SMIL().solve(scanner))
}