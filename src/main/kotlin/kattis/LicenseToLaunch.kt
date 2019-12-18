package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class LicenseToLaunch {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        var min = Int.MAX_VALUE
        var current = 0

        for (i in 0 until n) {
            val c = scanner.nextInt()
            if (c < min) {
                min = c
                current = i
            }
        }
        return current.toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(LicenseToLaunch().solve(scanner))
}