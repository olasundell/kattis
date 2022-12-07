package kattis;

import java.util.Scanner;
import kotlin.math.max

/**
 * TODO write documentation
 */
class Speeding {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val pairs = (0 until n).map { scanner.nextInt() to scanner.nextInt() }

        var m = 0

        (1 until pairs.size).forEach {
            val t = pairs[it].first - pairs[it - 1].first
            val distance = pairs[it].second - pairs[it - 1].second
            val speed = distance / t

            m = max(m, speed)
        }

        return "$m"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Speeding().solve(scanner))
}