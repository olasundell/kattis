package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class DigitSwap {
    fun solve(scanner: Scanner): String {
        return scanner.next().reversed()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(DigitSwap().solve(scanner))
}