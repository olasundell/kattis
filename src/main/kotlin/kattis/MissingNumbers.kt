package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class MissingNumbers {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val set = mutableSetOf<Int>()
        var last = -1
        repeat(n) {
            last = scanner.nextInt()
            set.add(last)
        }

        val missing = mutableListOf<Int>()

        for (i in 1..last) {
            if (!set.contains(i)) {
                missing.add(i)
            }
        }

        return if (missing.isEmpty()) {
            "good job"
        } else {
            missing.joinToString(separator = "\n")
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(MissingNumbers().solve(scanner))
}