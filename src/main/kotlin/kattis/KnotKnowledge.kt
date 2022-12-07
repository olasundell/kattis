package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class KnotKnowledge {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val shouldKnow = (1..n).map { scanner.nextInt() }.toSet()
        val known = (1 until n).map { scanner.nextInt() }.toSet()

        return "${shouldKnow.minus(known).first()}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(KnotKnowledge().solve(scanner))
}