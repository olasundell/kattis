package adventofcode.y2021;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec2 {
    fun solve(scanner: Scanner): String {
        var x = 0
        var y = 0

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val verb = line.split(" ")[0]
            val n = line.split(" ")[1].toInt()

            when (verb) {
               "forward" -> x += n
                "up" -> y -= n
                "down" -> y += n
            }
        }

        return "${x*y}"
    }

    fun solve2(scanner: Scanner): String {
        var x = 0
        var y = 0
        var aim = 0

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val verb = line.split(" ")[0]
            val n = line.split(" ")[1].toInt()

            when (verb) {
                "forward" -> {
                    x += n
                    y += n * aim
                }
                "up" -> aim -= n
                "down" -> aim += n
            }
        }

        return "${x*y}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec2().solve(scanner))
}