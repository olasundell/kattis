package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class IWannaBe {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val k = scanner.nextInt()

        val pokenoms = (0 until n).map { Pokenom(scanner.nextLong(), scanner.nextLong(), scanner.nextLong()) }

        val chosen = mutableSetOf<Pokenom>()

        chosen.addAll(pokenoms.sortedByDescending { it.attack }.take(k))
        chosen.addAll(pokenoms.sortedByDescending { it.defense }.take(k))
        chosen.addAll(pokenoms.sortedByDescending { it.health }.take(k))

        return chosen.size.toString()
    }

    data class Pokenom(val attack: Long, val defense: Long, val health: Long)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(IWannaBe().solve(scanner))
}