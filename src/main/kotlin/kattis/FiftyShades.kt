package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FiftyShades {
    val regex = Regex("(pink|rose)")
    fun solve(scanner: Scanner): String {
        var c = 0

        while (scanner.hasNext()) {
            val s = scanner.next().toLowerCase()
            if (s.contains(regex)) {
                c++
            }
        }
        return if (c > 0) {
            "${c}"
        } else {
            "I must watch Star Wars with my daughter"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FiftyShades().solve(scanner))
}