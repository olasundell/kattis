package adventofcode.y2019;

import java.util.Scanner;
import kotlin.math.floor

/**
 * TODO write documentation
 */
class Dec1 {
    fun solve(scanner: Scanner): String {
        var result = 0L
        while (scanner.hasNextInt()) {
            val n = scanner.nextInt().toLong()
            result += calc(n)
        }
        return result.toString()
    }

    fun calc(n: Long): Long {
        val floor = floor(n / 3.0).toLong() - 2

        return if (floor <= 0) {
            0
        } else {
            return floor + calc(floor)
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec1().solve(scanner))
}