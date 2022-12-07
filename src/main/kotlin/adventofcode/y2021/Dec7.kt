package adventofcode.y2021;

import java.util.Scanner;
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.roundToInt

/**
 * TODO write documentation
 */
class Dec7 {
    fun solve(scanner: Scanner): String {
        val crabs = scanner.nextLine().split(",").map { it.toInt() }.sorted()

        val med = crabs[crabs.size / 2]

        val sum = crabs.sumOf { abs(it - med) }

        return "$sum"
    }

    fun solve2(scanner: Scanner): String {
        val crabmarines = scanner.nextLine().split(",").map { it.toInt() }.sorted()

        val averageFloor = crabmarines.average().toInt()        // check lower
        val averageCiel = crabmarines.average().roundToInt()    // possibly check upper

        val fuelToAverageFloor = crabmarines.sumToAverage(averageFloor)
        val fuelToAverage = if (averageFloor != averageCiel) {
            min(fuelToAverageFloor, crabmarines.sumToAverage(averageCiel))
        } else {
            fuelToAverageFloor
        }

        return "$fuelToAverage"
    }

    fun List<Int>.sumToAverage(ave: Int) =
        this.sumOf {
            val diff = abs(it - ave)
            diff * (1 + diff) / 2
        }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec7().solve(scanner))
}