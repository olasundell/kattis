package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class GCVWR {
    fun solve(scanner: Scanner): String {
        val maxGross = scanner.nextInt()
        val truckWeight = scanner.nextInt()
        val noOfItems = scanner.nextInt()

        val totalItemWeight = (0 until noOfItems).map { scanner.nextInt() }.sum()

        val netGross = (9 * (maxGross - truckWeight)) / 10

        return "${netGross - totalItemWeight}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println(GCVWR().solve(scanner))
}