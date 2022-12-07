package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Mult {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val nums = (0 until n).map { scanner.nextInt() }

        val mults = mutableListOf<Int>()

        var result = 0 to nums

        do {
            result = playOnce(result.second)
            if (result.first == 0) {
                return mults.joinToString(separator = "\n")
            } else {
                mults.add(result.first)
            }
        } while (result != 0 to listOf<Int>())

        return ""
    }

    private fun playOnce(nums: List<Int>): Pair<Int, List<Int>> {
        val first = nums.first()

        (1 until nums.size).forEach {
            if (nums[it] % first == 0) {
                return nums[it] to nums.subList(it + 1, nums.size)
            }
        }

        return 0 to listOf()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Mult().solve(scanner))
}