package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class LostLineup {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        if (n == 1) {
            return "1"
        }

        scanner.nextLine()

        val between = scanner.nextLine().split(" ").map { it.toInt() }

        val arr = Array(n) { 1 }

        for (i in 1 until n) {
            arr[between[i - 1]  + 1] = i + 1
        }

        return arr.joinToString(separator = " ")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(LostLineup().solve(scanner))
}