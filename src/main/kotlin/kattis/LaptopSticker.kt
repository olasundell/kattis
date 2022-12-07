package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class LaptopSticker {
    fun solve(scanner: Scanner): String {
        val wc = scanner.nextInt()
        val hc = scanner.nextInt()
        val ws = scanner.nextInt()
        val hs = scanner.nextInt()

        return if (wc - ws >= 2 && hc - hs >= 2) {
            "1"
        } else {
            "0"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(LaptopSticker().solve(scanner))
}