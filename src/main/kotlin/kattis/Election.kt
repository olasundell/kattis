package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Election {
    fun solve(scanner: Scanner): String {
        val votes = mutableMapOf<String, Int>()
        val parties = mutableMapOf<String, String>()
        val n = scanner.nextInt()
        scanner.nextLine()

        repeat (n) {
            val name = scanner.nextLine()
            val party = scanner.nextLine()
            votes[name] = 0
            parties[name] = party
        }

        val m = scanner.nextInt()
        scanner.nextLine()

        repeat (m) {
            val vote = scanner.nextLine()
            if (votes.containsKey(vote)) {
                votes[vote] = votes[vote]!! + 1
            }
        }

        val sorted: List<Map.Entry<String, Int>> = votes.toMap().entries.sortedByDescending { it.value }

        if (sorted[0].value == sorted[1].value) {
            return "tie"
        }

        return parties[sorted[0].key]!!
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Election().solve(scanner))
}