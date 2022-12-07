package adventofcode.y2021;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec10 {

    fun solve(scanner: Scanner): String {
        var score = 0

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val stack = ArrayDeque<Char>()
            line.forEach {
                if (it.open()) {
                    stack.add(it)
                } else {
                    val s = stack.removeLast()
                    if (it != s.opposed()) {
                        score += it.score()
                    }
                }
            }
        }
        return "$score"
    }

    fun solve2(scanner: Scanner): String {
        val scores = mutableListOf<Long>()
        var error = false
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val stack = ArrayDeque<Char>()
            line.forEach {
                if (it.open()) {
                    stack.add(it)
                } else {
                    val s = stack.removeLast()
                    if (it != s.opposed()) {
                        error = true
                    }
                }
            }

            var score = 0L
            while (!error && stack.isNotEmpty()) {
                val s = stack.removeLast()
                score *= 5L
                score += s.opposed().score2()
            }

            if (!error) {
                scores.add(score)
            }

            error = false
        }

        scores.sort()

        return "${scores[scores.size / 2]}"
    }


    fun Char.score(): Int {
        return when (this) {
            ')' -> 3
            ']' -> 57
            '}' -> 1197
            '>' -> 25137
            else -> 0
        }
    }

    fun Char.open(): Boolean = this == '(' || this == '[' || this == '{' || this == '<'
    fun Char.opposed(): Char {
        return when (this) {
            '{' -> '}'
            '(' -> ')'
            '[' -> ']'
            '<' -> '>'
            else -> ' '
        }
    }

    fun Char.score2(): Long {
        return when (this) {
            ')' -> 1L
            ']' -> 2L
            '}' -> 3L
            '>' -> 4L
            else -> 0L
        }
    }

    fun score(c: Char): Long {
        return when (c) {
            ')' -> 3L
            ']' -> 57L
            '}' -> 1197L
            '>' -> 25137L
            else -> 0L
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec10().solve(scanner))
}