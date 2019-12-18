package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class FastFood {
    fun solve(scanner: Scanner): String {
        val noOfCases = scanner.nextInt()
        val results = mutableListOf<Int>()

        for (i in 0 until noOfCases) {
            results.add(case(scanner))
        }

        return results.joinToString(separator = "\n")
    }

    private fun case(scanner: Scanner): Int {
        val noOfPrizes = scanner.nextInt()
        val noOfStickers = scanner.nextInt()
        val prizes = readPrizes(noOfPrizes, scanner)
        val stickers = readStickers(noOfStickers, scanner)

        return calcResult(prizes, stickers)
    }

    private fun calcResult(prizes: Set<Prize>, stickers: Map<Int, Int>): Int {
        var total = 0
        for (p in prizes) {
            var minSt = Int.MAX_VALUE
            for (ps in p.stickers) {
                minSt = Math.min(stickers.getOrDefault(ps, 0), minSt)
            }

            total += p.cash * minSt
        }

        return total
    }

    private fun readStickers(noOfStickers: Int, scanner: Scanner): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()

        for (i in 1..noOfStickers) {
            map[i] = scanner.nextInt()
        }

        return map.toMap()
    }

    private fun readPrizes(noOfPrizes: Int, scanner: Scanner): Set<Prize> {
        val prizes: MutableSet<Prize> = mutableSetOf<Prize>()

        for (i in 0 until noOfPrizes) {
            val nSt = scanner.nextInt()
            val st = mutableSetOf<Int>()

            for (j in 0 until nSt) {
                st.add(scanner.nextInt())
            }

            prizes.add(Prize(st, scanner.nextInt()))
        }
        return prizes.toSet()
    }

    data class Prize(val stickers: Set<Int>, val cash: Int)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(FastFood().solve(scanner))
}