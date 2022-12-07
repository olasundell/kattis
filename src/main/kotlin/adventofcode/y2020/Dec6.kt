package adventofcode.y2020;

import java.util.Scanner;
import kotlin.streams.toList

/**
 * TODO write documentation
 */
class Dec6 {
    fun solve2(scanner: Scanner): String {
        var sum = 0
        while (scanner.hasNextLine()) {
            val sets = mutableListOf<Set<Int>>()
            var l = scanner.nextLine()
            while (l.isNotEmpty() && scanner.hasNextLine()) {
                sets.add(l.chars().toList().toSet())
                l = scanner.nextLine()
            }

            sum += sets.reduce { acc, it -> acc.intersect(it) }.size
        }

        return "$sum"
    }

    fun solve(scanner: Scanner): String {
        var sum = 0
        while (scanner.hasNextLine()) {
            val set = mutableSetOf<Int>()
            var l = scanner.nextLine()
            while (l.isNotEmpty() && scanner.hasNextLine()) {
                set.addAll(l.chars().toList())
                l = scanner.nextLine()
            }

            sum += set.size
        }

        return "$sum"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec6().solve(scanner))
}