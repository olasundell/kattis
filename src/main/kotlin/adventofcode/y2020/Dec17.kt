package adventofcode.y2020;

import java.util.Scanner;
import kotlin.math.max

/**
 * TODO write documentation
 */
class Dec17 {
    fun solve(scanner: Scanner): String {
        val liveCells = mutableListOf<Pt>()

        var row = 0
        var maxX = 0
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            line.forEachIndexed { index, c -> if (c == '#') {
                maxX = max(maxX, index)
                liveCells.add(Pt(index, row, 0))
            } }


            row++
        }

        var zBound = Pair(0, 0)
        var yBound = Pair(0, row - 1)
        var xBound = Pair(0, maxX)

        return ""
    }

    data class Pt(val x: Int, val y: Int, val z: Int)
//    data class State(bleh)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec17().solve(scanner))
}