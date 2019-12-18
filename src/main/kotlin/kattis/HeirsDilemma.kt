package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class HeirsDilemma {
    fun solve(scanner: Scanner): String {
        val from = scanner.nextInt()
        val to = scanner.nextInt()
        var n = 0

        for (i in from..to) {
            if (check(i)) {
                n++
            }
        }
        return n.toString()
    }

    private fun check(i: Int): Boolean {
        val s = i.toString()
        if (s.toSet().size != s.length || s.contains('0')) {
            return false
        }

        for (c in s) {
            if (i % c.toString().toInt() != 0) {
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(HeirsDilemma().solve(scanner))
}