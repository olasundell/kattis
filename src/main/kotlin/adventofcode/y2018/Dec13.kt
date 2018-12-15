package adventofcode.y2018;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec13 {
    fun solve(scanner: Scanner): String {
        val lines = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine())
        }

        val upLeft = mutableListOf<Point>()

        for (i in 0 until lines.size) {

        }

        return ""
    }

    data class Point(val x: Int, val y: Int)

    data class Square(val upLeft: Point, val downRight: Point, val pos: Point, val direction: Int)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec13().solve(scanner))
}