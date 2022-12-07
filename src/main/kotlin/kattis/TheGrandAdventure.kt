package kattis;

import java.util.*

/**
 * TODO write documentation
 */
class TheGrandAdventure {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()

        return (0 until n).joinToString(separator = "\n") { ableToFinish(scanner.nextLine()) }
    }

    /*
        $ represents Money
        | represents Incense
        * represents Gem
        t represents a Trader
        j represents a Jeweler
        b represents a Banker
        $ -> b
        | -> t
        * -> j
     */
    val items = arrayOf('$', '|', '*')
    val map = mapOf('j' to '*', 't' to '|', 'b' to '$')

    private fun ableToFinish(line: String): String {
        val filtered = line.replace(".", "")

        val stack = ArrayDeque<Char>()


        filtered.forEach {
            if (it in items) {
                stack.push(it)
            } else {
                if (stack.isEmpty()) {
                    return "NO"
                }

                val c = stack.pop()
                if (map[it] != c) {
                    return "NO"
                }
            }
        }

        return if (stack.isEmpty()) {
            "YES"
        } else {
            "NO"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(TheGrandAdventure().solve(scanner))
}