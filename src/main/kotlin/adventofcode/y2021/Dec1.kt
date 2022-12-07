package adventofcode.y2021;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec1 (private val winSize: Int = 1) {
    fun solve(scanner: Scanner): String {
        var r = listOf(scanner.nextInt())
        while (scanner.hasNextInt()) {
            r = r + scanner.nextInt()
        }

        var c = 0
        var prev = r.window(0)

        for (i in (1 ..r.size - winSize)) {
            val curr = r.window(i)
            if (curr > prev) {
                c++
            }

            prev = curr
        }

        return "$c"
    }

    private fun List<Int>.window(idx: Int): Int = this.subList(idx, winSize + idx).sum()
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec1().solve(scanner))
}