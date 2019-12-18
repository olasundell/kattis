package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class IcpcAwards {
    fun solve(scanner: Scanner): String {
        val unis = mutableSetOf<String>()
        val list = mutableListOf<String>()
        val n = scanner.nextInt()

        for (i in 1..n) {
            val uni = scanner.next()
            val team = scanner.next()

            if (!unis.contains(uni)) {
                unis.add(uni)
                list.add("$uni $team")
            }
        }

        return list.subList(0, 12).joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(IcpcAwards().solve(scanner))
}