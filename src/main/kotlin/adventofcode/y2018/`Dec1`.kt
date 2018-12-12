package adventofcode.y2018

import java.util.*

class Dec1 {
    fun solve(scanner: Scanner): String {
        var sum = 0
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt()
        }
        return sum.toString()
    }

    fun solve2(scanner: Scanner): String {
        val list = mutableListOf<Int>()
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt())
        }

        var idx = 0
        var sum = 0
        val set = mutableSetOf(0)

        while (true) {
            sum += list[idx]
            if (!set.add(sum)) {
                return sum.toString()
            }
            idx = (idx + 1) % list.size
        }

        return sum.toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec1().solve(scanner))
}
