package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Peasoup {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextLine().toInt()

        for (i in 0 until n) {
            val noOfItems = scanner.nextLine().toInt()
            val name = scanner.nextLine()
            var peaSoup = false
            var pancakes = false
            for (j in 0 until noOfItems) {
                val str = scanner.nextLine()
                if (str == "pea soup") {
                    peaSoup = true
                } else if (str == "pancakes") {
                    pancakes = true
                }
            }

            if (peaSoup && pancakes) {
                return name
            }
        }

        return "Anywhere is fine I guess"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Peasoup().solve(scanner))
}