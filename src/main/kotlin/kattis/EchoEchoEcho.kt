package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class EchoEchoEcho {
    fun solve(scanner: Scanner): String {
        val w = scanner.next()
        return "${w} ${w} ${w}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(EchoEchoEcho().solve(scanner))
}