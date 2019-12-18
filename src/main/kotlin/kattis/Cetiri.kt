package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Cetiri {
    fun solve(scanner: Scanner): String {
        val s = listOf(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())
        val nums = s.sorted()

        val dOne = nums[1] - nums[0]
        val dTwo = nums[2] - nums[1]

        if (dOne == dTwo) {
            return (nums[2] + dOne).toString()
        } else if (dOne > dTwo) {
            return (nums[0] + dTwo).toString()
        } else {
            return (nums[1] + dOne).toString()
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Cetiri().solve(scanner))
}