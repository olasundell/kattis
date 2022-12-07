package kattis;

import java.awt.Point
import java.util.Scanner;

/**
 * TODO write documentation
 */
class NPuzzle {

    fun solve(scanner: Scanner): String {
        val correct = mapTo("ABCDEFGHIJKLMNO.")
        val current = mapTo(scanner.nextLine() + scanner.nextLine() + scanner.nextLine() + scanner.nextLine())

        val sum = current.filterNot { it.key == '.' }.map { Math.abs(correct[it.key]!!.x - it.value.x) + Math.abs(correct[it.key]!!.y - it.value.y) }.sum()

        return sum.toString()
    }

    fun mapTo(s: String): Map<Char, Point> {
        return mapOf(
                s[0] to Point(0, 0),
                s[1] to Point(1, 0),
                s[2] to Point(2, 0),
                s[3] to Point(3, 0),
                s[4] to Point(0, 1),
                s[5] to Point(1, 1),
                s[6] to Point(2, 1),
                s[7] to Point(3, 1),
                s[8] to Point(0, 2),
                s[9] to Point(1, 2),
                s[10] to Point(2, 2),
                s[11] to Point(3, 2),
                s[12] to Point(0, 3),
                s[13] to Point(1, 3),
                s[14] to Point(2, 3),
                s[15] to Point(3, 3)
        )
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(NPuzzle().solve(scanner))
}