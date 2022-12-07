package adventofcode.y2020;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec2 {
    fun solve(scanner: Scanner): String {
        var correct = 0
        while (scanner.hasNextLine()) {
            if (isValidPw2(scanner.nextLine(), this::pw)) {
                correct++
            }
        }

        return "$correct"
    }

    fun solve2(scanner: Scanner): String {
        var correct = 0
        while (scanner.hasNextLine()) {
            if (isValidPw2(scanner.nextLine(), this::pw2)) {
                correct++
            }
        }

        return "$correct"
    }

    private fun isValidPw2(line: String, check: (pw: String, min: Int, max: Int, c: Char) -> Boolean): Boolean {
        val regex = "(?<min>\\d+)-(?<max>\\d+) (?<char>[a-z]): (?<pw>[a-z]+)".toRegex()

        val match = regex.matchEntire(line)!!

        val min = match.groups["min"]!!.value.toInt()
        val max = match.groups["max"]!!.value.toInt()
        val c = match.groups["char"]!!.value.toCharArray()[0]
        val pw = match.groups["pw"]!!.value

        return check(pw, min, max, c)
    }

    private fun pw(pw: String, min: Int, max: Int, c: Char): Boolean {
        val count = pw.count { it == c }

        return count in min..max
    }
    private fun pw2(pw: String, min: Int, max: Int, c: Char): Boolean = (pw[min - 1] == c) xor (pw[max - 1] == c)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec2().solve(scanner))
}