package kattis

import java.util.*

class LastFactorialDigit {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val list = mutableListOf<Int>()

        while (scanner.hasNext()) {
            list.add(lastDigit(scanner.nextInt()))
        }

        return list.joinToString("\n")
    }

    private fun lastDigit(factor: Int): Int {
        var r = 1
        for (i in 1..factor) {
            r *= i
        }

//        return r.toString().last().toString().toInt()
        return r % 10
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(LastFactorialDigit().solve(scanner))
}