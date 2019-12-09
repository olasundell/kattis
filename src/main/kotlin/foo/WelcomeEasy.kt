package foo

import java.util.Scanner;

/**
 * TODO write documentation
 */
class WelcomeEasy {
    private val welcome = "welcome to code jam"
    private val alphabet = welcome.toCharArray().toSet()

    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()
        val results = mutableListOf<String>()

        for (i in 1..n) {
            val nextLine = scanner.nextLine()
            results.add(calc(i, nextLine.dropWhile { it != 'w' }.filter { alphabet.contains(it) }))
        }
        return results.joinToString(separator = "\n")
    }

    private fun calc(i: Int, nextLine: String): String {
        val charMap: MutableMap<Char, MutableList<Int>> = mutableMapOf()

        nextLine.forEachIndexed { idx, c ->
            charMap.computeIfAbsent(c) { _ -> mutableListOf() }.add(idx)
        }

        val sum = charMap['w']?.map {
            recurse(1, it, charMap)
        }?.sum() ?: 0

        val padded = padSum(sum)
        return "Case #$i: $padded"
    }

    fun padSum(sum: Int) = (sum % 10000).toString().padStart(4, '0')

    private fun recurse(
            idx: Int,
            pos: Int,
            charMap: MutableMap<Char, MutableList<Int>>
    ): Int {
        // we've reached the end of the string, we're done
        if (idx == welcome.length - 1) {
            return 1
        }

        // find the next char
        val nextPositions = charMap[welcome[idx]]?.filter { it > pos }?.toList() ?: listOf()

        // no chars left in front of us, unnecessary code but good for readability
        if (nextPositions.isEmpty()) {
            return 0
        }

        // iterate over found positions and recurse
        return nextPositions.map {
            recurse(idx + 1, it, charMap)
        }.sum()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(WelcomeEasy().solve(scanner))
}