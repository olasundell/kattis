package kattis

import java.util.*

/**
 * TODO write documentation
 */
class ProvincesAndGold {
    fun solve(scanner: Scanner): String {
        val gold = scanner.nextInt()
        val silver = scanner.nextInt()
        val copper = scanner.nextInt()

        val power = gold * 3 + silver * 2 + copper * 1
        return victory(power) + treasure(power)
    }

    private fun victory(power: Int): String = when (power) {
            in 0..1 -> ""
            in 2..4 -> "Estate or "
            in 5..7 -> "Duchy or "
            else -> "Province or "
        }

    private fun treasure(power: Int): String = when (power) {
        in 0..2 -> "Copper"
        in 3..5 -> "Silver"
        else -> "Gold"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ProvincesAndGold().solve(scanner))
}
