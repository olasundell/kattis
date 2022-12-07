package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Heimavinna {
    fun solve(scanner: Scanner): String {
        val ranges = scanner.next().split(";");

        return ranges.map {
            if (it.contains("-")) {
                val arr = it.split("-").map { it.toInt() }
                arr[1] - arr[0] + 1
            } else {
                1
            }
        }.sum().toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println(Heimavinna().solve(scanner))
}