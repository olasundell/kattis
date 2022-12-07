package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class TransitWoes {
    fun solve(scanner: Scanner): String {
        val leaveAt = scanner.nextInt()
        val classesStart = scanner.nextInt()
        val routes = scanner.nextInt()

        scanner.nextLine()

        val allWalks = scanner.nextLine().split(" ").map { it.toInt() }
        val walks = allWalks.subList(0, allWalks.size - 1)
        val rideLength = scanner.nextLine().split(" ").map { it.toInt() }
        val rideFreq = scanner.nextLine().split(" ").map { it.toInt() }

        var current = leaveAt

        for (r in 0 until routes) {
            current += walks[r]
            current += remainderOrZero(current, rideFreq[r])
            current += rideLength[r]

            if (current > classesStart) {
                return "no"
            }
        }

        current += allWalks.last()

        if (current > classesStart) {
            return "no"
        }

        return "yes"
    }

    fun remainderOrZero(n: Int, d: Int): Int {
        if (n % d == 0) {
            return 0
        }
        return d - (n % d)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(TransitWoes().solve(scanner))
}