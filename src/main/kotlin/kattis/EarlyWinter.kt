package kattis

import java.util.*

class EarlyWinter {
    fun solve(scanner: Scanner): String {
        val years = scanner.nextInt()
        val currentDay = scanner.nextInt()

        for (i in 0 until years) {
            if (scanner.nextInt() <= currentDay) {
                return "It hadn't snowed this early in $i years!"
            }
        }

        return "It had never snowed this early!"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(EarlyWinter().solve(scanner))
}