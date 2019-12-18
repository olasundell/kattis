package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class RunLengthEncodingRun {
    fun solve(scanner: Scanner): String {
        val command = scanner.next()
        val str = scanner.next()

        return if ("E".equals(command)) {
            encode(str)
        } else {
            decode(str)
        }
    }

    private fun encode(string: String): String {
        var curr = string[0]
        var occ = 1
        var result = ""

        for (c in string.substring(1)) {
            if (curr == c) {
                occ++
            } else {
                result += "$curr$occ"
                curr = c
                occ = 1
            }
        }

        result += "$curr$occ"

        return result
    }

    private fun decode(string: String): String {
        val chunked = string.chunked(2)

        return chunked.map(this::decodeChar).joinToString(separator = "")
    }

    private fun decodeChar(pair: String): String {
        val c = pair[0]
        val n = pair[1] - '0'
        var result = ""

        for (i in 0 until n) {
            result += c
        }

        return result
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(RunLengthEncodingRun().solve(scanner))
}