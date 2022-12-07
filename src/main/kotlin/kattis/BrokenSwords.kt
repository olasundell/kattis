package kattis;

import java.util.Collections.min
import java.util.Scanner;
import kotlin.math.min

/**
 * TODO write documentation
 */
class BrokenSwords {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()
        var f = 0
        var b = 0
        var l = 0
        var r = 0

        repeat(n) {
            val line = scanner.nextLine()
            f += if (line[0] == '0') {
                1
            } else {
                0
            }
            b += if (line[1] == '0') {
                1
            } else {
                0
            }
            l += if (line[2] == '0') {
                1
            } else {
                0
            }
            r += if (line[3] == '0') {
                1
            } else {
                0
            }
        }

        val fb = f + b
        val lr = l + r

        val swords = min(fb, lr) / 2

        return "$swords ${f + b - (swords * 2)} ${l + r - (swords * 2)}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(BrokenSwords().solve(scanner))
}