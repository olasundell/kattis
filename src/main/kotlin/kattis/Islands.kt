package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Islands {
    fun solve(scanner: Scanner): String {
        val noOfTests = scanner.nextInt()
        val results = mutableListOf<Int>()

        for (i in 1..noOfTests) {
            results.add(processIsland(scanner))
        }
        return results.mapIndexed { index, i -> "${index + 1} $i" }.joinToString(separator = "\n")
    }

    private fun processIsland(scanner: Scanner): Int {
        // discard line number, irrelevant
        scanner.nextInt()

        var past = 0
        var noOfIslands = 0

        val currentIslands = mutableSetOf<Int>()

        for (i in 1..12) {
            val current = scanner.nextInt()
            if (current != past) {
                if (current > past) {
                    currentIslands.add(current)
                } else {
                    if (!currentIslands.contains(current)) {
                        currentIslands.add(current)
                    }

                    for (j in past downTo current + 1) {
                        if (currentIslands.remove(j)) {
                            noOfIslands++
                        }
                    }
                }
            }

            past = current
        }

        return noOfIslands
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Islands().solve(scanner))
}